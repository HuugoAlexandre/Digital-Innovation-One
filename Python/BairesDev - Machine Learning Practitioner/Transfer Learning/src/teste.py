import numpy as np
from keras.preprocessing import image
from tensorflow.keras.models import load_model

# Carregar o modelo salvo e os pesos
model = load_model('meu_modelo.h5')
model.load_weights('meus_pesos.weights.h5')

def verificar_imagem(img_path):
    # Carregar a imagem
    img = image.load_img(img_path, target_size=(150, 150))

    # Converter a imagem para um array de numpy
    img_array = image.img_to_array(img)

    # Adicionar uma dimensão extra para representar o batch (tamanho 1)
    img_array = np.expand_dims(img_array, axis=0)

    # Normalizar a imagem (igual ao que foi feito no treinamento)
    img_array = img_array / 255.0

    # Fazer a previsão
    prediction = model.predict(img_array)

    prob_cachorro = prediction[0][0]  # Probabilidade de ser cachorro
    prob_gato = 1 - prob_cachorro  # Probabilidade de ser gato

    print(f"Probabilidade de ser cachorro: {prob_cachorro * 100:.2f}%")
    print(f"Probabilidade de ser gato: {prob_gato * 100:.2f}%")

    # Verificar o resultado (0: cachorro, 1: gato)
    if prob_cachorro > 0.5:
        print("A imagem é de um Cachorro!")
    else:
        print("A imagem é de um Gato!")

img_path = 'C:/Users/Hugo/Desktop/ml/transfer_learning/bet/2.webp'
verificar_imagem(img_path)
