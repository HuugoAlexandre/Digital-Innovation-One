"""
Executando o programa, todas as classes deram 1 e acurácia 0.99, sensibilidade 0.99 e F-score 0.99.
Isso significa uma dessas 3 possibilidades: overfitting, modelo perfeito ou problema nos dados.
"""

import tensorflow as tf
import matplotlib.pyplot as plt
import tensorflow as tf
import numpy as np
import seaborn as sns
import pandas as pd
from sklearn.preprocessing import label_binarize
from tensorflow.keras import datasets, layers, models

tf.__version__

logdir='log'

(train_images, train_labels), (test_images, test_labels) = datasets.mnist.load_data()

train_images = train_images.reshape((60000, 28, 28,1))
test_images = test_images.reshape((10000, 28, 28,1 ))

train_images, test_images = train_images / 255.0, test_images / 255.0

model = models.Sequential()
model.add(layers.Conv2D(32, (3,3), activation='relu', input_shape=(28, 28, 1)))
model.add(layers.MaxPooling2D((2,2)))
model.add(layers.Conv2D(64, (3,3), activation='relu'))
model.add(layers.MaxPooling2D((2,2)))
model.add(layers.Conv2D(64, (3,3), activation='relu'))

model.add(layers.Flatten())
model.add(layers.Dense(64, activation='relu'))
model.add(layers.Dense(10, activation='softmax'))

tensorboard_callback = tf.keras.callbacks.TensorBoard(logdir, histogram_freq=1)

model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
model.fit(x=train_images, y=train_labels, epochs=5, validation_data=(test_images, test_labels))

y_true=test_labels
y_pred_prob = model.predict(test_images)
y_pred = np.argmax(y_pred_prob, axis=1)

con_mat = tf.math.confusion_matrix(labels=y_true, predictions=y_pred).numpy()

con_mat_norm = np.around(con_mat.astype('float') / con_mat.sum(axis=1)[:, np.newaxis], decimals=2)

classes = [str(i) for i in range(10)]
con_mat_df = pd.DataFrame(con_mat_norm, index=classes, columns=classes)

figure = plt.figure(figsize=(8, 8))
sns.heatmap(con_mat_df, annot=True, cmap=plt.cm.Blues)
plt.tight_layout()
plt.ylabel('True label')
plt.xlabel('Predicted label')
plt.show()

from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, roc_curve, auc
import matplotlib.pyplot as plt

accuracy = accuracy_score(y_true, y_pred)
recall = recall_score(y_true, y_pred, average='macro')
precision = precision_score(y_true, y_pred, average='macro')
f1 = f1_score(y_true, y_pred, average='macro')

print(f"Acurácia: {accuracy:.2f}")
print(f"Sensibilidade (Recall): {recall:.2f}")
print(f"F-score: {f1:.2f}")

y_true_bin = label_binarize(y_true, classes=[i for i in range(10)])
n_classes = y_true_bin.shape[1]

# Calcular a ROC e AUC para cada classe
fpr = {}
tpr = {}
roc_auc = {}

for i in range(n_classes):
    # Usa as probabilidades para cada classe (y_pred_prob) ao invés dos índices das previsões (y_pred)
    fpr[i], tpr[i], _ = roc_curve(y_true_bin[:, i], y_pred_prob[:, i])
    roc_auc[i] = auc(fpr[i], tpr[i])

plt.figure(figsize=(8, 8))
for i in range(n_classes):
    plt.plot(fpr[i], tpr[i], label=f"Classe {i} (AUC = {roc_auc[i]:.2f})")

plt.plot([0, 1], [0, 1], 'k--')
plt.xlabel("False Positive Rate")
plt.ylabel("True Positive Rate")
plt.title("Curva ROC")
plt.legend(loc="lower right")
plt.show()
