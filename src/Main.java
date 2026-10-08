import taller_mecanico.Auto;
import taller_mecanico.Furgon;
import taller_mecanico.Garantizable;
import taller_mecanico.GestorTaller;
import taller_mecanico.Vehiculo;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            GestorTaller gestor = new GestorTaller();

            Vehiculo auto1 = new Auto(
                    "Toyota", 2020, 15000, "Yaris", true
            );

            Vehiculo auto2 = new Auto(
                    "Hyundai", 2018, 80000, "Accent", false
            );

            Vehiculo furgon1 = new Furgon(
                    "Toyota", 2022, 40000, 2.0
            );

            Vehiculo furgon2 = new Furgon(
                    "Peugeot", 2021, 35000, 1.2
            );

            System.out.println("=== REGISTRO ===");

            gestor.registrarVehiculo(auto1);
            gestor.registrarVehiculo(auto2);
            gestor.registrarVehiculo(furgon1);
            gestor.registrarVehiculo(furgon2);

            System.out.println();

            gestor.mostrarVehiculos();

            System.out.println("=== BÚSQUEDA POR MARCA ===");

            List<Vehiculo> encontrados = gestor.buscarPorMarca("Toyota");

            // Muestro las coincidencias de la búsqueda.
            for (Vehiculo vehiculo : encontrados) {
                System.out.println(vehiculo);
            }

            System.out.println();
            System.out.println("=== DESCUENTOS ===");

            System.out.println("Auto con 10%: $"
                    + auto1.calcularCostoServicio(10));

            System.out.println("Furgón con 20%: $"
                    + furgon1.calcularCostoServicio(20));

            System.out.println();
            System.out.println("=== GARANTÍA ===");

            Garantizable garantiaAuto = (Garantizable) auto1;

            System.out.println("Garantía inicial: "
                    + garantiaAuto.tieneGarantiaActiva());

            garantiaAuto.activarGarantia();

            System.out.println("Garantía final: "
                    + garantiaAuto.tieneGarantiaActiva());

        } catch (IllegalArgumentException e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }
}