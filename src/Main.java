package taller_mecanico;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LecturaEntrada entrada = new LecturaEntrada(scanner);

        GestorTaller gestor = new GestorTaller();

        Auto autoToyota = new Auto(
                "Toyota", 2022, 18000, "Yaris", true
        );

        Auto autoChevrolet = new Auto(
                "Chevrolet", 2018, 62000, "Sail", false
        );

        Furgon furgonToyota = new Furgon(
                "Toyota", 2020, 45000, 2.0
        );

        Furgon furgonHyundai = new Furgon(
                "Hyundai", 2023, 12000, 1.0
        );

        autoToyota.activarGarantia();

        System.out.println("=== REGISTRO DE VEHÍCULOS ===");

        gestor.registrarVehiculo(autoToyota);
        gestor.registrarVehiculo(autoChevrolet);
        gestor.registrarVehiculo(furgonToyota);
        gestor.registrarVehiculo(furgonHyundai);

        System.out.println();

        System.out.println("=== BÚSQUEDA OFICIAL TOYOTA ===");

        List<Vehiculo> encontrados = gestor.buscarPorMarca("Toyota");

        System.out.println("Resultados encontrados: " + encontrados.size());

        gestor.mostrarDetalleVehiculos(encontrados);

        System.out.println("=== LISTADO OFICIAL ===");
        gestor.mostrarVehiculos();

        int opcion = 0;

        // El menú se mantiene hasta que el usuario quiera salir.
        while (opcion != 4) {

            System.out.println();
            System.out.println("===== TALLER AUTOFIX =====");
            System.out.println("1. Listar vehículos");
            System.out.println("2. Buscar por marca");
            System.out.println("3. Simular costo con descuento");
            System.out.println("4. Salir");

            opcion = entrada.leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:

                    gestor.mostrarVehiculos();
                    break;

                case 2:

                    String marca = entrada.leerTexto(
                            "Ingrese marca a buscar: "
                    );

                    List<Vehiculo> resultados = gestor.buscarPorMarca(marca);

                    if (resultados.isEmpty()) {
                        System.out.println("No se encontraron vehículos.");
                    } else {
                        System.out.println("Vehículos encontrados: "
                                + resultados.size());

                        gestor.mostrarDetalleVehiculos(resultados);
                    }

                    break;

                case 3:

                    List<Vehiculo> vehiculos = gestor.obtenerVehiculos();

                    System.out.println("=== SELECCIONAR VEHÍCULO ===");

                    for (int i = 0; i < vehiculos.size(); i++) {
                        System.out.println((i + 1) + ". " + vehiculos.get(i));
                    }

                    int numeroVehiculo;

                    // Vuelvo a pedir el número si no existe en el listado.
                    while (true) {

                        numeroVehiculo = entrada.leerEntero(
                                "Seleccione un vehículo: "
                        );

                        if (numeroVehiculo >= 1
                                && numeroVehiculo <= vehiculos.size()) {
                            break;
                        }

                        System.out.println("Seleccione un vehículo válido.");
                    }

                    double descuento = entrada.leerDescuento();

                    Vehiculo seleccionado = vehiculos.get(numeroVehiculo - 1);

                    System.out.println("Vehículo: " + seleccionado);

                    System.out.println("Costo normal: $"
                            + seleccionado.calcularCostoServicio());

                    System.out.println("Costo con descuento: $"
                            + seleccionado.calcularCostoServicio(descuento));

                    break;

                case 4:

                    System.out.println("Saliendo del sistema AutoFix...");
                    break;

                default:

                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}