def read_ppm(filename):
    with open(filename, 'rb') as f:
        header = f.readline().decode().strip()
        if header != 'P6':
            raise ValueError('Arquivo não está no formato PPM P6.')
        dimensions = f.readline().decode().strip().split()
        width, height = int(dimensions[0]), int(dimensions[1])
        max_val = int(f.readline().decode().strip())
        pixels = f.read()
    return width, height, max_val, pixels

def save_ppm(filename, width, height, max_val, pixels):
    with open(filename, 'wb') as f:
        f.write(f'P6\n{width} {height}\n{max_val}\n'.encode())
        f.write(pixels)

def rgb_to_gray(r, g, b):
    return int(0.299 * r + 0.587 * g + 0.114 * b)

width, height, max_val, pixels = read_ppm('nome_imagem.ppm')

gray_pixels = bytearray()
for i in range(0, len(pixels), 3):
    r = pixels[i]
    g = pixels[i+1]
    b = pixels[i+2]
    gray = rgb_to_gray(r, g, b)
    gray_pixels.extend([gray, gray, gray])

save_ppm('gray_image.ppm', width, height, max_val, gray_pixels)

