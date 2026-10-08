import taller_mecanico.Auto;
import taller_mecanico.Furgon;
import taller_mecanico.GestorTaller;
import taller_mecanico.Vehiculo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            GestorTaller gestor = new GestorTaller();

            // Datos oficiales para la evaluación.
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

            // Activo la garantía del Toyota después de crearlo.
            System.out.println("=== GARANTÍA TOYOTA ===");

            System.out.println("Estado inicial: "
                    + autoToyota.tieneGarantiaActiva());

            autoToyota.activarGarantia();

            System.out.println("Estado actual: "
                    + autoToyota.tieneGarantiaActiva());

            System.out.println();

            System.out.println("=== REGISTRO DE VEHÍCULOS ===");

            gestor.registrarVehiculo(autoToyota);
            gestor.registrarVehiculo(autoChevrolet);
            gestor.registrarVehiculo(furgonToyota);
            gestor.registrarVehiculo(furgonHyundai);

            System.out.println();

            System.out.println("=== BÚSQUEDA TOYOTA ===");

            List<Vehiculo> encontrados = gestor.buscarPorMarca("Toyota");

            System.out.println("Resultados encontrados: "
                    + encontrados.size());

            gestor.mostrarDetalleVehiculos(encontrados);

            System.out.println("=== LISTADO FINAL ===");

            gestor.mostrarVehiculos();

        } catch (IllegalArgumentException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }
}