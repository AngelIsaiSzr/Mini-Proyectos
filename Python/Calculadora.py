import tkinter as tk

class Calculator(tk.Tk):
    def __init__(self):
        super().__init__()

        # Configurar la ventana
        self.title("Calculadora")
        self.geometry("370x500")
        self.resizable(False, False)

        # Crear los botones de la calculadora
        self.buttons = [
            {"text": "Exit", "row": 1, "column": 0},
            {"text": "C", "row": 1, "column": 1},
            {"text": "CE", "row": 1, "column": 2},
            {"text": "/", "row": 1, "column": 3},
            {"text": "7", "row": 2, "column": 0},
            {"text": "8", "row": 2, "column": 1},
            {"text": "9", "row": 2, "column": 2},
            {"text": "*", "row": 2, "column": 3},
            {"text": "4", "row": 3, "column": 0},
            {"text": "5", "row": 3, "column": 1},
            {"text": "6", "row": 3, "column": 2},
            {"text": "-", "row": 3, "column": 3},
            {"text": "1", "row": 4, "column": 0},
            {"text": "2", "row": 4, "column": 1},
            {"text": "3", "row": 4, "column": 2},
            {"text": "+", "row": 4, "column": 3},
            {"text": "0", "row": 5, "column": 0},
            {"text": "00", "row": 5, "column": 1},
            {"text": ".", "row": 5, "column": 2},
            {"text": "=", "row": 5, "column": 3},
        ]

        # Crear los botones y agregarlos a la ventana
        for button in self.buttons:
            # Crear un botón con los parámetros del diccionario
            btn = tk.Button(
                self,
                text=button["text"],
                width=5,
                height=2,
                font=("Arial", 18),
                # Usar una función lambda para pasar el texto del botón al manejador de eventos
                command=lambda x=button["text"]: self.handle_button_click(x)
            )
            # Agregar el botón a la ventana, usando los parámetros de posición del diccionario
            btn.grid(
                row=button["row"],
                column=button["column"],
                padx=5,
                pady=5,
                columnspan=button.get("columnspan", 1)
            )

        # Actualizar el comando del botón "Exit" para salir del programa
        self.buttons[0]["command"] = self.quit

        # Crear la entrada para mostrar el resultado
        self.display = tk.Entry(
            self,
            width=16,
            font=("Arial", 28),
            justify="right",
            state="disabled",
            disabledbackground="white",
            disabledforeground="black"
        )
        # Agregar la entrada a la ventana, ocupando todas las columnas
        self.display.grid(row=0, column=0, columnspan=4, padx=10, pady=10)

    def handle_button_click(self, button):
        if button == "=":
            # Evaluar la expresión matemática y mostrar el resultado
            try:
                result = eval(self.display.get())
                self.display.config(state="normal")
                self.display.delete(0, tk.END)
                self.display.insert(0, str(result))
                self.display.config(state="disabled")
            except:
                # Si hay un error en la expresión, mostrar "Error"
                self.display.config(state="normal")
                self.display.delete(0, tk.END)
                self.display.insert(0, "Error")
                self.display.config(state="disabled")
        elif button == "C":
            # Borrar todo
            self.display.config(state="normal")
            self.display.delete(0, tk.END)
            self.display.config(state="disabled")
        elif button == "CE":
            # Borrar el último dígito
            self.display.config(state="normal")
            self.display.delete(len(self.display.get()) - 1, tk.END)
            self.display.config(state="disabled")
        elif button == "Exit":
            # Salir del programa
            self.quit()
        elif button == "00":
            # Agregar "00" a la entrada
            self.display.config(state="normal")
            self.display.insert(tk.END, "00")
            self.display.config(state="disabled")
        else:
            # Agregar el botón presionado a la entrada
            self.display.config(state="normal")
            self.display.insert(tk.END, button)
            self.display.config(state="disabled")

# Crear la instancia de la calculadora y ejecutar el bucle de eventos
if __name__ == "__main__":
    calc = Calculator()
    calc.mainloop()
