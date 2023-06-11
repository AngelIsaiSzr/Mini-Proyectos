// Importamos la clase JOptionPane para poder mostrar cuadros de diálogo en la aplicación
import javax.swing.JOptionPane;

public class MenuMatematico {

    public static void main(String[] args) {

        int opc1 = 0;

        // Se utiliza un ciclo do-while para mostrar el menú principal hasta que el
        // usuario seleccione la opción de salir
        do {

            try {
                // Se muestra el menú principal y se guarda la opción seleccionada por el
                // usuario en la variable opc1
                String opc1Str = JOptionPane.showInputDialog("Menu Principal \n1.- Tablas \n2.- Calculadora \n3.- Conversor \n4.- Salir");

                // Si el usuario selecciona cancelar o cierra la ventana, se termina la
                // aplicación
                if (opc1Str == null) {
                    return;
                }

                // Se convierte la opción seleccionada por el usuario a un entero y se guarda en
                // la variable opc1
                opc1 = Integer.parseInt(opc1Str);

            } catch (NumberFormatException e) {
                // Si el usuario ingresa una opción no válida, se muestra un mensaje de error y
                // se continúa el ciclo
                JOptionPane.showMessageDialog(null, "Error: debe ingresar un número válido");
                continue;
            }

            // Se utiliza un switch para manejar las opciones seleccionadas por el usuario
            // en el menú principal
            switch (opc1) {
                case 1:
                    do {
                        String tablaStr = JOptionPane.showInputDialog("¿Qué tabla desea ver? \nIngrese 0 para regresar");
                        if (tablaStr == null) {
                            return;
                        }
                        try {
                            // Se convierte la opción seleccionada por el usuario a un entero y se guarda en
                            // la variable tabla
                            int tabla = Integer.parseInt(tablaStr);

                            // Si el usuario selecciona la opción de regresar, se termina el ciclo y se
                            // regresa al menú principal
                            if (tabla == 0) {
                                break;
                            }

                            // Se genera la tabla de multiplicar y se muestra en un cuadro de diálogo
                            String resultado = "";
                            for (int i = 1; i <= 10; i++) {
                                resultado += tabla + " x " + i + " = " + i * tabla + "\n";
                            }
                            JOptionPane.showMessageDialog(null, resultado);

                        } catch (NumberFormatException e) {
                            // Si el usuario ingresa una opción no válida, se muestra un mensaje de error y
                            // se continúa el ciclo
                            JOptionPane.showMessageDialog(null, "Error: debe ingresar un número válido");
                            continue;
                        }
                    } while (true);
                    break;
                case 2:
                    int opc2;
                    double num1, num2, suma, resta, multiplicacion, division;

                    do {
                        try {
                            String opc2Str = JOptionPane.showInputDialog("Digite una opcion: \n1.- Suma \n2.- Resta \n3.- Multiplicacion \n4.- Division \n5.- Regresar");
                            if (opc2Str == null) {
                                return;
                            }
                            // Se convierte la opción seleccionada por el usuario a un entero y se guarda en
                            // la variable opc2
                            opc2 = Integer.parseInt(opc2Str);
                        } catch (NumberFormatException e) {
                            // Si el usuario ingresa una opción no válida, se muestra un mensaje de error y
                            // se inicializa la variable opc2 en 0
                            opc2 = 0;
                        }

                        // Se utiliza otro switch para manejar las operaciones seleccionadas por el
                        // usuario en la calculadora
                        switch (opc2) {
                            case 1:
                                try {
                                    // Se pide al usuario que ingrese los dos números a sumar
                                    String num1Str = JOptionPane.showInputDialog("Digite el primer numero: ");
                                    if (num1Str == null) {
                                        return;
                                    }
                                    num1 = Double.parseDouble(num1Str);

                                    String num2Str = JOptionPane.showInputDialog("Digite el segundo numero: ");
                                    if (num2Str == null) {
                                        return;
                                    }
                                    num2 = Double.parseDouble(num2Str);

                                    // Se realiza la suma y se muestra en un cuadro de diálogo
                                    suma = num1 + num2;
                                    JOptionPane.showMessageDialog(null, "El suma es: " + suma);

                                } catch (NumberFormatException e) {
                                    // Si el usuario ingresa un valor no válido, se muestra un mensaje de error
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 2:
                                try {
                                    // Se pide al usuario que ingrese los dos números a restar
                                    String num1Str = JOptionPane.showInputDialog("Digite el primer numero: ");
                                    if (num1Str == null) {
                                        return;
                                    }
                                    num1 = Double.parseDouble(num1Str);

                                    String num2Str = JOptionPane.showInputDialog("Digite el segundo numero: ");
                                    if (num2Str == null) {
                                        return;
                                    }
                                    num2 = Double.parseDouble(num2Str);

                                    // Se realiza la resta y se muestra en un cuadro de diálogo
                                    resta = num1 - num2;
                                    JOptionPane.showMessageDialog(null, "La resta es: " + resta);

                                } catch (NumberFormatException e) {
                                    // Si el usuario ingresa un valor no válido, se muestra un mensaje de error
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 3:
                                try {
                                    // Se pide al usuario que ingrese los dos números a multiplicar
                                    String num1Str = JOptionPane.showInputDialog("Digite el primer numero: ");
                                    if (num1Str == null) {
                                        return;
                                    }
                                    num1 = Double.parseDouble(num1Str);

                                    String num2Str = JOptionPane.showInputDialog("Digite el segundo numero: ");
                                    if (num2Str == null) {
                                        return;
                                    }
                                    num2 = Double.parseDouble(num2Str);

                                    // Se realiza la multiplicación y se muestra en un cuadro de diálogo
                                    multiplicacion = num1 * num2;
                                    JOptionPane.showMessageDialog(null, "La multiplicacion es: " + multiplicacion);

                                } catch (NumberFormatException e) {
                                    // Si el usuario ingresa un valor no válido, se muestra un mensaje de error
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 4:
                                try {
                                    // Se pide al usuario que ingrese los dos números a dividir
                                    String num1Str = JOptionPane.showInputDialog("Digite el primer numero: ");
                                    if (num1Str == null) {
                                        return;
                                    }
                                    num1 = Double.parseDouble(num1Str);

                                    String num2Str = JOptionPane.showInputDialog("Digite el segundo numero: ");
                                    if (num2Str == null) {
                                        return;
                                    }
                                    num2 = Double.parseDouble(num2Str);

                                    // Se verifica si el segundo número es cero para evitar una división por cero
                                    if (num2 == 0) {
                                        JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
                                    } else {
                                        // Se realiza la división y se muestra en un cuadro de diálogo
                                        division = num1 / num2;
                                        JOptionPane.showMessageDialog(null, "La division es: " + division);
                                    }

                                } catch (NumberFormatException e) {
                                    // Si el usuario ingresa un valor no válido, se muestra un mensaje de error
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 5:
                                // Si el usuario selecciona la opción de regresar, se termina el ciclo y se
                                // regresa al menú principal
                                break;
                            default:
                                // Si el usuario ingresa una opción no válida, se muestra un mensaje de error
                                JOptionPane.showMessageDialog(null, "Error: seleccione una opción válida");
                                break;
                        }
                    } while (opc2 != 5);
                    break;
                case 3:
                    int opc3;
                    do {
                        try {
                            String menu = JOptionPane.showInputDialog("Seleccione una opción: \n1.- Conversor de Temperatura \n2.- Conversor de Moneda \n3.- Conversor de Longitud \n4.- Regresar");
                            if (menu == null) {
                                return;
                            }
                            // Se convierte la opción seleccionada por el usuario a un entero y se guarda en
                            // la variable opc3
                            opc3 = Integer.parseInt(menu);
                        } catch (NumberFormatException e) {
                            opc3 = 0;
                        }

                        // Se utiliza otro switch para manejar la opcion seleccionada por el
                        // usuario en el conversor
                        switch (opc3) {
                            case 1:
                                // Conversor de temperatura
                                String tempStr;

                                // Ciclo para validar el valor ingresado
                                do {
                                    try {
                                        tempStr = JOptionPane.showInputDialog("Ingrese la temperatura a convertir \nIngrese 0 para regresar");
                                        if (tempStr == null) {
                                            return;
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error: debe ingresar un número.");
                                        tempStr = "0";
                                    }
                                    double temperatura = 0;
                                    try {
                                        temperatura = Double.parseDouble(tempStr);
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error: debe ingresar un número válido");
                                        continue;
                                    }
                                    if (!tempStr.equals("0")) {
                                        String escalaOrigen = JOptionPane.showInputDialog("Ingrese la escala de origen: \nC = Celsius \nF = Fahrenheit \nK = Kelvin");
                                        if (!escalaOrigen.equals("C") && !escalaOrigen.equals("F") && !escalaOrigen.equals("K")) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione una escala válida");
                                            continue;
                                        }
                                        String escalaDestino = JOptionPane.showInputDialog("Ingrese la escala de destino: \nC = Celsius \nF = Fahrenheit \nK = Kelvin");
                                        if (!escalaDestino.equals("C") && !escalaDestino.equals("F") && !escalaDestino.equals("K")) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione una escala válida");
                                            continue;
                                        }

                                        if (escalaOrigen.equals(escalaDestino)) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione escalas diferentes");
                                            continue;
                                        }

                                        double resultado = 0;
                                        switch (escalaOrigen) {
                                            case "C":
                                                if (escalaDestino.equals("F")) {
                                                    resultado = (temperatura * 1.8) + 32;
                                                } else {
                                                    resultado = temperatura + 273.15;
                                                }
                                                break;
                                            case "F":
                                                if (escalaDestino.equals("C")) {
                                                    resultado = (temperatura - 32) / 1.8;
                                                } else {
                                                    resultado = ((temperatura - 32) / 1.8) + 273.15;
                                                }
                                                break;
                                            case "K":
                                                if (escalaDestino.equals("C")) {
                                                    resultado = temperatura - 273.15;
                                                } else {
                                                    resultado = ((temperatura - 273.15) * 1.8) + 32;
                                                }
                                                break;
                                        }
                                        JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
                                    }
                                } while (!tempStr.equals("0"));
                                break;
                            case 2:
                                // Conversor de moneda
                                String montoStr;

                                // Ciclo para validar el valor ingresado
                                do {
                                    try {
                                        montoStr = JOptionPane.showInputDialog("Ingrese el monto a convertir \nIngrese 0 para regresar");
                                        if (montoStr == null) {
                                            return;
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error: debe ingresar un número.");
                                        montoStr = "0";
                                    }
                                    double monto = 0;
                                    try {
                                        monto = Double.parseDouble(montoStr);
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error: debe ingresar un número válido");
                                        continue;
                                    }
                                    if (!montoStr.equals("0")) {
                                        String monedaOrigen = JOptionPane.showInputDialog("Ingrese la moneda de origen: \nUSD = Dólares Americanos \nEUR = Euros \nMXN = Pesos Mexicanos \nCOP = Pesos Colombianos");
                                        if (!monedaOrigen.equals("USD") && !monedaOrigen.equals("EUR") && !monedaOrigen.equals("MXN") && !monedaOrigen.equals("COP")) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione una moneda válida");
                                            continue;
                                        }
                                        String monedaDestino = JOptionPane.showInputDialog("Ingrese la moneda de destino: \nUSD = Dólares Americanos \nEUR = Euros \nMXN = Pesos Mexicanos \nCOP = Pesos Colombianos");
                                        if (!monedaDestino.equals("USD") && !monedaDestino.equals("EUR") && !monedaDestino.equals("MXN") && !monedaDestino.equals("COP")) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione una moneda válida");
                                            continue;
                                        }

                                        if (monedaOrigen.equals(monedaDestino)) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione monedas diferentes");
                                            continue;
                                        }

                                        double resultado = 0;
                                        switch (monedaOrigen) {
                                            case "USD":
                                                switch (monedaDestino) {
                                                    case "EUR":
                                                        resultado = monto * 0.85;
                                                        break;
                                                    case "MXN":
                                                        resultado = monto * 20.03;
                                                        break;
                                                    case "COP":
                                                        resultado = monto * 3630.28;
                                                        break;
                                                }
                                                break;
                                            case "EUR":
                                                switch (monedaDestino) {
                                                    case "USD":
                                                        resultado = monto * 1.18;
                                                        break;
                                                    case "MXN":
                                                        resultado = monto * 23.54;
                                                        break;
                                                    case "COP":
                                                        resultado = monto * 4265.16;
                                                        break;
                                                }
                                                break;
                                            case "MXN":
                                                switch (monedaDestino) {
                                                    case "USD":
                                                        resultado = monto * 0.05;
                                                        break;
                                                    case "EUR":
                                                        resultado = monto * 0.04;
                                                        break;
                                                    case "COP":
                                                        resultado = monto * 181.78;
                                                        break;
                                                }
                                                break;
                                            case "COP":
                                                switch (monedaDestino) {
                                                    case "USD":
                                                        resultado = monto * 0.00027;
                                                        break;
                                                    case "EUR":
                                                        resultado = monto * 0.00023;
                                                        break;
                                                    case "MXN":
                                                        resultado = monto * 0.0055;
                                                        break;
                                                }
                                                break;
                                        }
                                        JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
                                    }
                                } while (!montoStr.equals("0"));
                                break;
                            case 3:
                                // Conversor de longitud
                                String valorStr;

                                // Ciclo para validar el valor ingresado
                                do {
                                    try {
                                        valorStr = JOptionPane.showInputDialog("Ingrese el valor a convertir \nIngrese 0 para regresar");
                                        if (valorStr == null) {
                                            return;
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                        valorStr = "0";
                                    }
                                    double valor = 0;
                                    try {
                                        valor = Double.parseDouble(valorStr);
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error: debe ingresar un número válido");
                                        continue;
                                    }
                                    if (!valorStr.equals("0")) {
                                        String unidadOrigen = JOptionPane.showInputDialog("Ingrese la unidad de origen: \nm = Metros \nkm = Kilometros \nin = Pies \nmi = Millas");
                                        if (!unidadOrigen.equals("m") && !unidadOrigen.equals("km") && !unidadOrigen.equals("in") && !unidadOrigen.equals("mi")) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione unidades válidas");
                                            continue;
                                        }
                                        String unidadDestino = JOptionPane.showInputDialog("Ingrese la unidad de destino:  \nm = Metros \nkm = Kilometros \nin = Pies \nmi = Millas");
                                        if (!unidadDestino.equals("m") && !unidadDestino.equals("km") && !unidadDestino.equals("in") && !unidadDestino.equals("mi")) {
                                            JOptionPane.showMessageDialog(null, "Error: seleccione unidades válidas");
                                            continue;
                                        }

                                        if (unidadOrigen.equals(unidadDestino)) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Error: seleccione unidades diferentes");
                                            continue;
                                        }

                                        double valorEnMetros = 0;
                                        switch (unidadOrigen) {
                                            case "m":
                                                valorEnMetros = valor;
                                                break;
                                            case "km":
                                                valorEnMetros = valor * 1000;
                                                break;
                                            case "in":
                                                valorEnMetros = valor / 3.2808;
                                                break;
                                            case "mi":
                                                valorEnMetros = valor * 1609.344;
                                                break;
                                        }

                                        double resultado = 0;
                                        switch (unidadDestino) {
                                            case "m":
                                                resultado = valorEnMetros;
                                                break;
                                            case "km":
                                                resultado = valorEnMetros / 1000;
                                                break;
                                            case "in":
                                                resultado = valorEnMetros * 3.2808;
                                                break;
                                            case "mi":
                                                resultado = valorEnMetros / 1609.344;
                                                break;
                                        }
                                        JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
                                    }
                                } while (!valorStr.equals("0"));
                                break;
                            case 4:
                                // Si el usuario selecciona la opción de regresar, se termina el ciclo y se
                                // regresa al menú principal
                                break;
                            default:
                                // Si el usuario ingresa una opción no válida, se muestra un mensaje de error
                                JOptionPane.showMessageDialog(null, "Error: seleccione una opción válida");
                        }
                    } while (opc3 != 4);
                    break;
                case 4:
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "Hasta Pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida!");
                    break;
            }
        } while (opc1 != 4);
    }
}
