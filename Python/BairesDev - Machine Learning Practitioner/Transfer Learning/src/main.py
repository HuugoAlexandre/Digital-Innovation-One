import os
import zipfile
import shutil
import numpy as np
from PIL import Image
from sklearn.model_selection import train_test_split
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras import layers, models
from tensorflow.keras.applications import MobileNetV2
from tensorflow.keras.preprocessing import image
from tensorflow.keras.models import load_model

# não vou upar esse arquivo no git, só ir buscar na net
zip_file_path = 'C:/Users/Hugo/Desktop/ml/transfer_learning/kagglecatsanddogs_5340.zip'
extract_path = 'C:/Users/Hugo/Desktop/ml/transfer_learning/'

# Caminho para a pasta 'PetImages'
dataset_path = os.path.join(extract_path, 'PetImages')

# Verificar se a pasta 'PetImages' já existe (dava problema quando roda várias vezes, por isso o if)
if not os.path.exists(dataset_path):
    # Se não existir, descompacta o arquivo
    with zipfile.ZipFile(zip_file_path, 'r') as zip_ref:
        zip_ref.extractall(extract_path)
    print("Arquivo descompactado com sucesso!")
else:
    print("Pasta 'PetImages' já existe. Pulando a extração.")

# Verificar o conteúdo da pasta 'PetImages'
print("Conteúdo da pasta 'PetImages':", os.listdir(dataset_path))

# Verificar as pastas 'Cat' e 'Dog'
cats_dir = os.path.join(dataset_path, "Cat")
dogs_dir = os.path.join(dataset_path, "Dog")

if os.path.exists(cats_dir):
    print("Número de imagens em 'Cat':", len(os.listdir(cats_dir)))
else:
    print("Pasta 'Cat' não encontrada!")

if os.path.exists(dogs_dir):
    print("Número de imagens em 'Dog':", len(os.listdir(dogs_dir)))
else:
    print("Pasta 'Dog' não encontrada!")


def remove_corrupted_images(folder_path):
    for file_name in os.listdir(folder_path):
        file_path = os.path.join(folder_path, file_name)
        try:
            with Image.open(file_path) as img:
                img.verify()  # Verifica se o arquivo é válido
        except (IOError, SyntaxError):
            print("Arquivo corrompido removido:", file_path)
            os.remove(file_path)

# Remover imagens corrompidas de ambas as pastas
remove_corrupted_images(cats_dir)
remove_corrupted_images(dogs_dir)

base_dir = "C:/Users/Hugo/Desktop/ml/transfer_learning/cats_dogs"
train_dir = os.path.join(base_dir, "train")
validation_dir = os.path.join(base_dir, "validation")

os.makedirs(os.path.join(train_dir, "cats"), exist_ok=True)
os.makedirs(os.path.join(train_dir, "dogs"), exist_ok=True)
os.makedirs(os.path.join(validation_dir, "cats"), exist_ok=True)
os.makedirs(os.path.join(validation_dir, "dogs"), exist_ok=True)

# Dividir os dados e copiá-los para os diretórios
def split_data(src_dir, train_dst, val_dst, split_ratio=0.8):
    files = [os.path.join(src_dir, f) for f in os.listdir(src_dir) if f.endswith(('.jpg', '.png'))]
    train_files, val_files = train_test_split(files, test_size=1-split_ratio)
    for file in train_files:
        shutil.copy(file, train_dst)
    for file in val_files:
        shutil.copy(file, val_dst)

# Organizar os dados
split_data(cats_dir, os.path.join(train_dir, "cats"), os.path.join(validation_dir, "cats"))
split_data(dogs_dir, os.path.join(train_dir, "dogs"), os.path.join(validation_dir, "dogs"))

print("Imagens de treino - gatos:", len(os.listdir(os.path.join(train_dir, "cats"))))
print("Imagens de treino - cachorros:", len(os.listdir(os.path.join(train_dir, "dogs"))))
print("Imagens de validação - gatos:", len(os.listdir(os.path.join(validation_dir, "cats"))))
print("Imagens de validação - cachorros:", len(os.listdir(os.path.join(validation_dir, "dogs"))))

# Criar geradores de treino e validação
train_datagen = ImageDataGenerator(rescale=1.0/255)
validation_datagen = ImageDataGenerator(rescale=1.0/255)

train_generator = train_datagen.flow_from_directory(
    train_dir,
    target_size=(150, 150),
    batch_size=32,
    class_mode="binary"
)

validation_generator = validation_datagen.flow_from_directory(
    validation_dir,
    target_size=(150, 150),
    batch_size=32,
    class_mode="binary"
)

# Carregar o modelo MobileNetV2 pré-treinado, excluindo a parte superior (camadas finais)
base_model = MobileNetV2(weights='imagenet', include_top=False, input_shape=(150, 150, 3))

# Congelar as camadas do modelo base para não treinar essas camadas
base_model.trainable = False

# Construir o modelo
model = models.Sequential([
    base_model,
    layers.GlobalAveragePooling2D(),
    layers.Dense(1, activation='sigmoid')  # Apenas uma saída (gato ou cachorro)
])

# Compilar o modelo
model.compile(optimizer='adam',
              loss='binary_crossentropy',
              metrics=['accuracy'])

# Resumo do modelo
model.summary()

history = model.fit(
    train_generator,
    epochs=10,
    validation_data=validation_generator
)

# Salvar o modelo completo e os pesos
model.save('meu_modelo_2.h5')
model.save_weights('meus_pesos.weights.h5')

img_path = 'C:/Users/Hugo/Desktop/ml/transfer_learning/bet/bb.jpg'

# Carregar a imagem, redimensionando para 150x150 pixels (o tamanho que o modelo espera, mas depende do modelo)
img = image.load_img(img_path, target_size=(150, 150))

# Converter a imagem para um array NumPy e normalizar (escalar os valores de 0 a 1)
img_array = image.img_to_array(img) / 255.0

# Adiciona uma dimensão extra para representar o batch (modelo espera um batch, mesmo que tenha só uma imagem)
img_array = np.expand_dims(img_array, axis=0)

print(img_array.shape)  # Verifica o formato da imagem

prediction = model.predict(img_array)

if prediction < 0.5:
    print("A imagem é um Gato!")
else:
    print("A imagem é um Cachorro!")