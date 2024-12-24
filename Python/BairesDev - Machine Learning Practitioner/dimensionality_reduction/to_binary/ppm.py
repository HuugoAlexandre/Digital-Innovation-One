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

def rgb_to_binary(r, g, b, threshold=128):
    gray = int(0.299 * r + 0.587 * g + 0.114 * b)
    return 255 if gray > threshold else 0

width, height, max_val, pixels = read_ppm('caminh\\imagem\\img.ppm')

binary_pixels = bytearray()
for i in range(0, len(pixels), 3):
    r = pixels[i]
    g = pixels[i+1]
    b = pixels[i+2]
    binary = rgb_to_binary(r, g, b)
    binary_pixels.extend([binary, binary, binary])

save_ppm('imagem_binaria.ppm', width, height, max_val, binary_pixels)
