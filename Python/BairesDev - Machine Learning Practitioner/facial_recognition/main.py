import cv2

# Carrega o classificador Haar cascade para detecção de rostos
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

def detect_face(image_path, output_path):
    # Carrega a imagem
    img = cv2.imread(image_path)

    # Converte a imagem para escala de cinza (necessário para o classificador Haar)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # Detecta rostos na imagem
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))

    # Desenha bounding boxes ao redor dos rostos detectados
    for (x, y, w, h) in faces:
        cv2.rectangle(img, (x, y), (x + w, y + h), (0, 255, 0), 2)

    # Salva a imagem com os bounding boxes
    cv2.imwrite(output_path, img)

    # Exibi a imagem com o bounding box
    cv2.imshow('Face Detection', img)

    # Espera até que uma tecla seja pressionada e então fechar a janela
    cv2.waitKey(0)
    cv2.destroyAllWindows()

image_path = 'caminho\\da\\imagem\\teste.jpg'
output_path = 'caminho\\da\\imagem\\teste.jpg'
detect_face(image_path, output_path)
