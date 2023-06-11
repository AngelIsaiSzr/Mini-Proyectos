# Importa los módulos necesarios
import tkinter as tk
import random
import string
import pyperclip

# Define la clase Password
class Password:
    def __init__(self, master):
        # Inicializa la ventana principal
        self.master = master
        master.title("Generador de Contraseñas")

        # Crea una etiqueta para mostrar el mensaje "Generando Contraseña"
        self.label_generando = tk.Label(master, text="Generando Contraseña...", font=('Helvetica', 16, 'bold'))
        self.label_generando.pack()

        # Crea una etiqueta para mostrar el mensaje "Contraseña"
        self.label_contrasena = tk.Label(master, text="Contraseña:", font=('Helvetica', 15, 'bold'))
        self.label_contrasena.pack()

        # Crea una cadena de caracteres que se utilizará para generar la contraseña
        lower = string.ascii_lowercase  # Letras minúsculas
        upper = string.ascii_lowercase  # Letras mayúsculas
        num = string.digits  # Números
        symbols = string.punctuation  # Símbolos
        chars = lower + upper + num + symbols  # Combinación de los caracteres
        self.temp = random.sample(chars, 10)  # Genera una lista aleatoria de 10 caracteres

        # Crea una etiqueta para mostrar la contraseña
        self.label = tk.Label(master, text="".join(self.temp), font=('Helvetica', 16))
        self.label.pack()

        # Crea un contenedor para la contraseña y los botones
        self.container = tk.Frame(master)
        self.container.pack()

        # Crea el botón "Generar Nueva Contraseña"
        self.button_generar = tk.Button(self.container, text="Generar Nueva Contraseña", font=('Helvetica', 12, 'bold'),
                                        bg='#4CAF50', fg='white', command=self.click)
        self.button_generar.pack(side='left', padx=5, pady=5)

        # Crea el botón "Copiar Contraseña"
        self.button_copiar = tk.Button(self.container, text="Copiar Contraseña", font=('Helvetica', 12, 'bold'),
                                       bg='#4CAF50', fg='white', command=self.copiar)
        self.button_copiar.pack(side='left', padx=5, pady=5)

    def click(self):
        # Actualiza la etiqueta de "Generando Contraseña"
        self.label_generando.config(text="Generando Contraseña...")

        # Genera una nueva lista aleatoria de caracteres para la contraseña
        lower = string.ascii_lowercase
        upper = string.ascii_lowercase
        num = string.digits
        symbols = string.punctuation
        chars = lower + upper + num + symbols
        self.temp = random.sample(chars, 10)

        # Actualiza la etiqueta de la contraseña con la nueva contraseña generada
        self.label.config(text="".join(self.temp))

    def copiar(self):
        # Copia la contraseña al portapapeles
        pyperclip.copy("".join(self.temp))
        # Imprime un mensaje indicando que la contraseña ha sido copiada al portapapeles
        print("Contraseña copiada al portapapeles.")


# Crea la ventana principal y la instancia de la clase Password
root = tk.Tk()
game = Password(root)
root.mainloop()
