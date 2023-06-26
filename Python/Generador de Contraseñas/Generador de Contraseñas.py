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

        # Crea una etiqueta para mostrar el mensaje "Longitud de la Contraseña"
        self.label_longitud = tk.Label(master, text="Longitud de la Contraseña:", font=('Helvetica', 15, 'bold'))
        self.label_longitud.pack()

        # Crea un cuadro de entrada de texto para la longitud de la contraseña
        self.entry_longitud = tk.Entry(master, font=('Helvetica', 16))
        self.entry_longitud.pack()

        # Crea una etiqueta para mostrar el mensaje "Contraseña"
        self.label_contrasena = tk.Label(master, text="Ingresa la longitud de la contraseña y genera una nueva", font=('Helvetica', 15, 'bold'))
        self.label_contrasena.pack()

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
        # Verifica si se ingresó una longitud de contraseña válida
        try:
            longitud = int(self.entry_longitud.get())
        except ValueError:
            self.label_contrasena.config(text="Ingresa una longitud de contraseña válida")
            return

        # Verifica si la longitud de contraseña ingresada es mayor que cero
        if longitud <= 0:
            self.label_contrasena.config(text="La longitud de la contraseña debe ser mayor que cero")
            return

        # Actualiza la etiqueta de "Contraseña"
        self.label_contrasena.config(text="Contraseña:")

        # Genera una lista aleatoria de caracteres para la contraseña
        lower = string.ascii_lowercase
        upper = string.ascii_uppercase
        num = string.digits
        symbols = string.punctuation
        chars = lower + upper + num + symbols
        self.temp = random.sample(chars, longitud)

        # Actualiza la etiqueta de la contraseña con la nueva contraseña generada
        self.label_contrasena.config(text="Contraseña: " + "".join(self.temp))

    def copiar(self):
        # Copia la contraseña al portapapeles
        pyperclip.copy("".join(self.temp))
        # Imprime un mensaje indicando que la contraseña ha sido copiada al portapapeles
        print("Contraseña copiada al portapapeles.")

# Crea la ventana principal y la instancia de la clase Password
root = tk.Tk()
game = Password(root)
root.mainloop()
