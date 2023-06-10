import tkinter as tk
import random

class SnakeGame:
    def __init__(self, master):
        # Se crea la ventana principal y se establece su título
        self.master = master
        master.title("Snake Game")

        # Se crea un canvas para dibujar el juego, con un fondo gris oscuro
        self.canvas = tk.Canvas(master, width=400, height=400, bg="gray20")
        self.canvas.pack()

        # Se inicializa el score y el top, y se crean las etiquetas correspondientes en el canvas
        self.score = 0
        self.top = 0
        self.score_label = self.canvas.create_text(10, 10, anchor="nw", text="Score: 0", fill="white", font=("Arial", 14))
        self.top_label = self.canvas.create_text(10, 30, anchor="nw", text="Top: {}".format(self.top), fill="white", font=("Arial", 14))
        
        # Se inicializa la serpiente y la comida, y se establece la dirección inicial
        self.snake = [(200, 200), (190, 200), (180, 200), (170, 200)]
        self.food = self.spawn_food()
        self.direction = "right"

        # Se asigna el evento de teclado a la función on_keypress
        self.canvas.bind_all("<Key>", self.on_keypress)

        # Se dibuja la serpiente y la comida en el canvas
        self.draw_snake()
        self.draw_food()

        # Se inicia el juego con la función play_game
        self.play_game()

    # Función para dibujar la serpiente en el canvas
    def draw_snake(self):
        self.canvas.delete("snake")
        for i, (x, y) in enumerate(self.snake):
            if i == 0:
                # Se establece el color de la cabeza de la serpiente en verde oscuro
                self.canvas.create_rectangle(x, y, x+20, y+20, fill="dark green", tags="snake")
            else:
                # Se establece el color del cuerpo de la serpiente en verde lima
                self.canvas.create_rectangle(x, y, x+20, y+20, fill="lime green", tags="snake")

    # Función para dibujar la comida en el canvas
    def draw_food(self):
        x, y = self.food
        self.canvas.create_oval(x, y, x+20, y+20, fill="red", tags="food")

    # Función para generar una nueva posición aleatoria para la comida
    def spawn_food(self):
        while True:
            x = random.randint(0, 19) * 20
            y = random.randint(0, 19) * 20
            # Se verifica que la posición generada no esté ocupada por ninguna sección de la serpiente
            if (x, y) not in self.snake:
                return (x, y)

    # Función para mover la serpiente en la dirección actual
    def move_snake(self):
        x, y = self.snake[0]
        if self.direction == "up":
            y -= 20
        elif self.direction == "down":
            y += 20
        elif self.direction == "left":
            x -= 20
        elif self.direction == "right":
            x += 20

        # Si la serpiente llega a la comida, se agrega una nueva sección a la serpiente y se genera una nueva posición para la comida
        if x == self.food[0] and y == self.food[1]:
            self.snake.append((x, y))
            self.food = self.spawn_food()
            self.canvas.delete("food")
            self.draw_food()

            # Se actualiza el score y el top
            self.score += 10
            self.canvas.itemconfigure(self.score_label, text="Score: {}".format(self.score))
            if self.score > self.top:
                self.top = self.score
                self.canvas.itemconfigure(self.top_label, text="Top: {}".format(self.top))

        # Se mueve la serpiente eliminando la última sección y agregando una nueva en la cabeza
        self.snake.pop()
        self.snake.insert(0, (x, y))

    # Función para verificar si la serpiente choca contra los bordes o contra sí misma
    def check_collisions(self):
        x, y = self.snake[0]
        if x < 0 or x > 380 or y < 0 or y > 380:
            return True
        for segment in self.snake[1:]:
            if x == segment[0] and y == segment[1]:
                return True
        return False

    # Función que se ejecuta cuando se presiona una tecla, para cambiar la dirección de la serpiente
    def on_keypress(self, event):
        if event.keysym == "Up":
            if self.direction != "down":
                self.direction = "up"
        elif event.keysym == "Down":
            if self.direction != "up":
                self.direction = "down"
        elif event.keysym == "Left":
            if self.direction != "right":
                self.direction = "left"
        elif event.keysym == "Right":
            if self.direction != "left":
                self.direction = "right"

    # Función que reinicia el juego
    def restart_game(self):
        # Se reinician las variables de la serpiente, la comida y la dirección
        self.snake = [(200, 200), (190, 200), (180, 200), (170, 200)]
        self.food = self.spawn_food()
        self.direction = "right"

        # Se elimina la serpiente y la comida del canvas
        self.canvas.delete("snake")
        self.canvas.delete("food")

        # Se eliminan todos los widgets de la ventana principal
        for widget in self.master.winfo_children():
            widget.destroy()

        # Se crea un nuevo canvas con el fondo gris oscuro
        self.canvas = tk.Canvas(self.master, width=400, height=400, bg="gray20")
        self.canvas.pack()

        # Se reinician el score y el top, y se crean las etiquetas correspondientes en el canvas
        self.score = 0
        self.score_label = self.canvas.create_text(10, 10, anchor="nw", text="Score: 0", fill="white", font=("Arial", 14))
        self.top_label = self.canvas.create_text(10, 30, anchor="nw", text="Top: {}".format(self.top), fill="white", font=("Arial", 14))
        
        # Se dibuja la serpiente y la comida en el canvas
        self.draw_snake()
        self.draw_food()

        # Se inicia el juego con la función play_game
        self.play_game()

    # Función que cierra el juego
    def exit_game(self):
        self.canvas.destroy()
        self.master.destroy()

    # Función principal del juego, que se llama recursivamente para actualizar el estado del juego
    def play_game(self):
        # Si la serpiente choca contra los bordes o contra sí misma, se muestra un mensaje de Game Over y se muestran botones para reiniciar o salir del juego
        if self.check_collisions():
            self.canvas.create_text(200, 200, text="Game Over", fill="white", font=("Arial", 30))
            restart_button = tk.Button(self.master, text="Restart", font=("Arial", 14), padx=10, pady=5, bg="green", fg="white", command=self.restart_game)
            restart_button.pack()
            exit_button = tk.Button(self.master, text="Exit", font=("Arial", 14), padx=10, pady=5, bg="red", fg="white", command=self.exit_game)
            exit_button.pack()
            return
        # Si la serpiente no choca, se mueve y se dibuja en el canvas, y se llama nuevamente a la función play_game después de un tiempo
        self.move_snake()
        self.draw_snake()
        self.master.after(100, self.play_game)

# Se crea la ventana principal y se inicia el juego
root = tk.Tk()
game = SnakeGame(root)
root.mainloop()
