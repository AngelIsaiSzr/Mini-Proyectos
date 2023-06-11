import tkinter as tk
import random

class GuessingGame:
    def __init__(self, master):
        # Inicialización de la clase GuessingGame
        self.master = master
        master.title("Adivina el número")

        # Generación de un número aleatorio y definición de la cantidad de intentos
        self.number = random.randint(1, 100)
        self.guesses_left = 10

        # Creación de una etiqueta para mostrar al jugador cuántos intentos tiene y en qué rango debe adivinar
        self.label = tk.Label(master, text="Tienes 10 intentos para adivinar un número entre 1 y 100.", font=("Arial", 12))
        self.label.pack()

        # Creación de un cuadro de entrada para que el jugador ingrese sus intentos
        self.entry = tk.Entry(master, font=("Arial", 12))
        self.entry.pack()

        # Creación de un botón para que el jugador envíe su intento
        self.button = tk.Button(master, text="Adivinar", font=("Arial", 12, "bold"), fg="white", bg="blue", activebackground="dark blue", command=self.start_game)
        self.button.pack(pady=5)

        # Creación de un botón para que el jugador comience un nuevo juego
        self.new_game_button = tk.Button(master, text="Nuevo juego", font=("Arial", 12, "bold"), fg="white", bg="green", activebackground="dark green", command=self.new_game)
        self.new_game_button.pack(pady=5)
        self.new_game_button.config(state="disabled")

        # Creación de un marco para mostrar el resultado de cada intento
        self.result_frame = tk.Frame(master)
        self.result_frame.pack(pady=5)

        # Creación de una etiqueta de texto dentro del marco para mostrar el resultado de cada intento
        self.result_label = tk.Label(self.result_frame, text="", font=("Arial", 12))
        self.result_label.pack()

        # Validación para asegurarse de que solo se ingresen números en el cuadro de entrada
        vcmd = master.register(self.validate)
        self.entry.config(validate="key", validatecommand=(vcmd, '%P'))

    def start_game(self):
        # Método que se ejecuta cuando el jugador presiona el botón "Adivinar"
        if self.entry.get() == "":
            # Comprobación de que el jugador haya ingresado un número
            self.result_label.config(text="Por favor ingresa un número.", fg="black")
            return

        guess = int(self.entry.get())
        self.entry.delete(0, tk.END)

        self.guesses_left -= 1

        if guess == self.number:
            # Comprobación de que el jugador haya adivinado el número
            self.result_label.config(text="¡Felicidades! ¡Adivinaste el número!", fg="green")
            self.button.config(state="disabled")
            self.new_game_button.config(state="normal")
        elif self.guesses_left == 0:
            # Comprobación de que el jugador se haya quedado sin intentos
            self.result_label.config(text="Lo siento, no adivinaste el número. El número era " + str(self.number) + ".", fg="red")
            self.button.config(state="disabled")
            self.new_game_button.config(state="normal")
        elif guess < self.number:
            # Comprobación de que el número ingresado por el jugador sea menor que el número generado aleatoriamente
            self.result_label.config(text="El número es mayor. Te quedan " + str(self.guesses_left) + " intentos.", fg="black")
        else:
            # Comprobación de que el número ingresado por el jugador sea mayor que el número generado aleatoriamente
            self.result_label.config(text="El número es menor. Te quedan " + str(self.guesses_left) + " intentos.", fg="black")

    def new_game(self):
        # Método que se ejecuta cuando el jugador presiona el botón "Nuevo juego"
        self.number = random.randint(1, 100)
        self.guesses_left = 10
        self.result_label.config(text="")
        self.button.config(state="normal")
        self.new_game_button.config(state="disabled")

    def validate(self, new_value):
        # Método que se utiliza para validar que el jugador solo ingrese números en el cuadro de entrada
        if not new_value:
            return True

        try:
            int(new_value)
            return True
        except ValueError:
            return False

root = tk.Tk()

# Personalización del estilo de la ventana principal
root.geometry("400x400")
root.configure(bg="white")

# Creación de una instancia de la clase GuessingGame y ejecución del bucle de eventos de tkinter
game = GuessingGame(root)
root.mainloop()
