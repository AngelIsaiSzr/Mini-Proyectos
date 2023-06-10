import javax.swing.JOptionPane;

public class MenuMatematico {

    public static void main(String[] args) {

        int opc1 = 0;

        do {

            try {
                String opc1Str = JOptionPane.showInputDialog("Menu Principal \n1.- Tablas \n2.- Calculadora \n3.- Conversor \n4.- Salir");
                if (opc1Str == null) {
                    return;
                }
                opc1 = Integer.parseInt(opc1Str);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: debe ingresar un número válido");
                continue;
            }

            switch (opc1) {
                case 1:
                do {
                    String tablaStr = JOptionPane.showInputDialog("¿Qué tabla desea ver? \nIngrese 0 para regresar");
                    if (tablaStr == null) {
                        return;
                    }
                    try {
                        int tabla = Integer.parseInt(tablaStr);
                        if (tabla == 0) {
                            break;
                        }
                        String resultado = "";
                        for (int i = 1; i <= 10; i++) {
                            resultado += tabla + " x " + i + " = " + i * tabla + "\n";
                        }
                        JOptionPane.showMessageDialog(null, resultado);
                    } catch (NumberFormatException e) {
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
                            opc2 = Integer.parseInt(opc2Str);
                        } catch (NumberFormatException e) {
                            opc2 = 0;
                        }

                        switch (opc2) {
                            case 1:
                                try {
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

                                    suma = num1 + num2;

                                    JOptionPane.showMessageDialog(null, "El suma es: " + suma);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 2:
                                try {
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

                                    resta = num1 - num2;

                                    JOptionPane.showMessageDialog(null, "La resta es: " + resta);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 3:
                                try {
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

                                    multiplicacion = num1 * num2;

                                    JOptionPane.showMessageDialog(null, "La multiplicacion es: " + multiplicacion);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 4:
                                try {
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

                                    if (num2 == 0) {
                                        JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
                                    } else {
                                        division = num1 / num2;
                                        JOptionPane.showMessageDialog(null, "La division es: " + division);
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número.");
                                }
                                break;
                            case 5:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Error: seleccione una opción válida");
                                break;
                        }
                    } while (opc2 != 5);
                    break;
                case 3:
                    String valorStr;

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
                                JOptionPane.showMessageDialog(null, "Error: seleccione unidades diferentes");
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
                    JOptionPane.showMessageDialog(null, "Hasta Pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida!");
                    break;
            }
        } while (opc1 != 4);

    }
}
