from ultralytics import YOLO
import cv2

# carrega o modelo YOLO
model = YOLO('yolov5su.pt')

image_path = 'C:\\caminho\\da\\imagem\\catinho.jpg'

# faz a inferência e salva as detecções
results = model.predict(source=image_path, save=True)
print(results)

# aalva manualmente a imagem processada
output_image = results[0].plot()  # Pega a imagem com as detecções
save_path = 'output_image.jpg'
cv2.imwrite(save_path, output_image)  # Salva a imagem processada
print(f"Imagem salva em: {save_path}")
