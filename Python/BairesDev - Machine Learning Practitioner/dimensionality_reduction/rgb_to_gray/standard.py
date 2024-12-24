import numpy as np
import matplotlib.pyplot as plt

# só uma representação de uma imagem de 4 pixels
# image = np.array([
#     [[255, 0, 0], [0, 255, 0]],
#     [[0, 0, 255], [0, 0, 0]]
# ])

image = plt.imread('\caminho\imagem.png')

plt.imshow(image)
plt.show()

def image_to_grayscale(image):
    gray = np.dot(image[...], [0.299, 0.587, 0.114])
    return gray

gray_image = image_to_grayscale(image)
plt.imshow(gray_image, cmap='gray')
plt.show()