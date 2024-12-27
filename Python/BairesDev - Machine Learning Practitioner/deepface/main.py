from deepface import DeepFace

img_path = "caminho\\da\\imagem\\teste.jpg"  # Substitua pelo caminho correto da imagem

# Realizando a análise de rosto com as ações desejadas
result = DeepFace.analyze(img_path=img_path, actions=['age', 'gender', 'emotion', 'race'])

# Imprimindo as análises
for analysis in result:
    age = analysis['age']
    print(f"Idade: {age}")

    dominant_emotion = analysis['dominant_emotion']
    print(f"Emoção dominante: {dominant_emotion}")

    dominant_gender = analysis['dominant_gender']
    print(f"Gênero dominante: {dominant_gender}")

    dominant_race = analysis['dominant_race']
    print(f"Raça dominante: {dominant_race}")

    print("\n---\n")  # Separador entre as análises de diferentes rostos
