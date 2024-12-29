"""
Aqui só funciona bem com o que já foi previamente treinado pelo modelo.
Se for adicionar outra classe, precisa treinar o modelo e adicionar uma nova classe (transfer learning).
"""

import os
import numpy as np
import requests
import matplotlib.pyplot as plt
from tensorflow.keras.preprocessing.image import load_img, img_to_array
from tensorflow.keras.applications import ResNet50
from tensorflow.keras.applications.resnet50 import preprocess_input
from tensorflow.keras.applications.resnet50 import decode_predictions
from io import BytesIO
from PIL import Image

# Configurações da API do Google Custom Search (pode ser outra, mas eu fiz pela GCS)
API_KEY = 'XXX'
SEARCH_ENGINE_ID = 'yyy'

# Carrega o modelo pré-treinado ResNet50
model = ResNet50(weights='imagenet')

# Função para classificar a imagem e obter a classe prevista
def classify_image(image_path, model):
    img = load_img(image_path, target_size=(224, 224))  # Redimensionar para 224x224 (tamanho esperado pela ResNet)
    img_array = img_to_array(img)
    img_array = np.expand_dims(img_array, axis=0)  # Adiciona a dimensão do batch
    img_array = preprocess_input(img_array)  # Pré-processa a imagem para o modelo

    predictions = model.predict(img_array)  # Obter as predições
    decoded_predictions = decode_predictions(predictions, top=1)[0]
    return decoded_predictions[0][1]  # Retorna o nome da classe prevista

# Função para buscar imagens na web usando a API do Google Custom Search
def search_images(query, num_results=5):
    search_url = f"https://www.googleapis.com/customsearch/v1?q={query}&cx={SEARCH_ENGINE_ID}&searchType=image&key={API_KEY}&num={num_results}"
    response = requests.get(search_url)
    results = response.json()

    # Extrair URLs das imagens
    image_urls = [item['link'] for item in results.get('items', [])]
    return image_urls

# Função para baixar e exibir imagens, com verificação do tipo de imagem
def download_and_display_images(image_urls):
    fig, axes = plt.subplots(1, len(image_urls), figsize=(15, 5))
    for ax, url in zip(axes, image_urls):
        try:
            # Verificar se a URL é válida e se é uma imagem
            response = requests.get(url, timeout=10)
            response.raise_for_status()  # Lançar exceção para códigos de status HTTP 4xx/5xx

            # Tentar carregar a imagem
            img_data = BytesIO(response.content)
            img = Image.open(img_data)

            # Verificar se é uma imagem válida
            img.verify()  # Verifica se o conteúdo é uma imagem válida
            img = load_img(img_data, target_size=(224, 224))  # Carregar a imagem
            ax.imshow(img)
            ax.axis('off')
        except requests.exceptions.RequestException as e:
            print(f"Erro na requisição: {e}")
            ax.axis('off')
        except (IOError, SyntaxError) as e:
            print(f"Erro ao carregar a imagem: {e}")
            ax.axis('off')
    plt.show()

test_image_path = "caminho\\da\\imagem" 

# Classificar a imagem de teste
classified_label = classify_image(test_image_path, model)
print(f"A classe identificada para a imagem de teste é: {classified_label}")

# Buscar imagens semelhantes na web com base na classe identificada
image_urls = search_images(classified_label, num_results=5)

# Exibir as imagens encontradas
download_and_display_images(image_urls)
