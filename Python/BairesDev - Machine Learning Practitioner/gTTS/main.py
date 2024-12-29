import pygame
import time
import os
import pyjokes
import webbrowser
import wikipedia
import speech_recognition as sr
from gtts import gTTS
from datetime import datetime
from pydub import AudioSegment

AudioSegment.ffmpeg = "caminho\\do\\bin\\do\\ffpeg"

def play_audio(text):
    try:
        tts = gTTS(text=text, lang="en", slow=False)
        audio_file = os.path.join(audio_dir, "gtts.mp3")
        tts.save(audio_file)
    
        if text != "tell me a joke":
            pygame.mixer.init()
            pygame.mixer.music.load(audio_file)
            pygame.mixer.music.play()
            
            while pygame.mixer.music.get_busy():
                time.sleep(1)
        pygame.mixer.quit()
    except Exception as e:
        ...

def recognize_audio(audio_path):
    if not os.path.exists(audio_path):
        print(f"O arquivo de áudio não foi encontrado: {audio_path}")
        return ""
    else:
        recognizer = sr.Recognizer()
        with sr.AudioFile(audio_path) as source:
            audio = recognizer.record(source)
            try:
                # converte o áudio em texto
                text = recognizer.recognize_google(audio)
                return text.lower()
            except sr.UnknownValueError:
                print("Não foi possível reconhecer o áudio.")
                return ""
            except sr.RequestError as e:
                print(f"Erro ao acessar o serviço de reconhecimento: {e}")
                return ""

def execute_command(command):
    if "search" in command and "youtube" in command:
        query = command.replace("search", "").replace("on youtube", "").strip()
        play_audio(f"Searching for {query} on YouTube")
        youtube_url = f"https://www.youtube.com/results?search_query={query}"        
        time.sleep(2)
        webbrowser.open(youtube_url)

    # essa biblioteca da wikipedia é meio paia, se não escrever como está lá ela não acha, depois eu vejo outra
    elif "search" in command and "wikipedia" in command:
        query = command.replace("search", "").replace("on wikipedia", "").strip()
        play_audio(f"Searching for {query} on Wikipedia")
        try:
            summary = wikipedia.summary(query, sentences=2)
            print(summary)
            play_audio(summary)
        except wikipedia.exceptions.DisambiguationError as e:
            print(f"Erro de ambiguidade: {e}")
            play_audio("Multiple results found. Please refine your query.")
        except wikipedia.exceptions.PageError:
            print("Página não encontrada.")
            play_audio("Page not found on Wikipedia.")

    elif "what time is it" in command:
        now = datetime.now().strftime("%H:%M")
        print(f"The current time is {now}")
        play_audio(f"The current time is {now}")

    elif "tell me a joke" in command:        
        joke = pyjokes.get_joke()
        print(joke)
        play_audio(joke)

    else:
        play_audio("Sorry, I can't help with that.")

def convert_mp3_to_wav(mp3_file):
    wav_file = mp3_file.replace(".mp3", ".wav")
    audio = AudioSegment.from_mp3(mp3_file)
    audio.export(wav_file, format="wav")

    # precisei remover porque estava dando muito problema de permissão
    if os.path.exists(mp3_file):
        os.remove(mp3_file)
    return wav_file

current_dir = os.path.dirname(os.path.abspath(__file__))
audio_dir = os.path.join(current_dir, "audio") 

# Testando a reprodução de áudio
play_audio("search giannis on youtube")

mp3_file = "caminho\\do\\audio\\gtts.mp3"
wav_file = convert_mp3_to_wav(mp3_file)
recognized_audio = recognize_audio(wav_file)
execute_command(recognized_audio)
