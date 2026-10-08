package taller_mecanico;

import java.util.Scanner;

public class LecturaEntrada {

    private Scanner scanner;

    public LecturaEntrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public int leerEntero(String mensaje) {

        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: debes ingresar un número entero.");
            }
        }
    }

    public double leerDescuento() {

        while (true) {
            System.out.print("Ingrese porcentaje de descuento: ");

            try {
                double descuento = Double.parseDouble(
                        scanner.nextLine().trim()
                );

                // El descuento solo puede estar entre 0 y 100.
                if (Double.isNaN(descuento)
                        || descuento < 0 || descuento > 100) {
                    System.out.println("El descuento debe estar entre 0 y 100.");
                } else {
                    return descuento;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}