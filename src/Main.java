import taller_mecanico.Auto;
import taller_mecanico.Furgon;
import taller_mecanico.Garantizable;
import taller_mecanico.Vehiculo;

public class Main {

    public static void main(String[] args) {

        try {
            Vehiculo auto1 = new Auto(
                    "Toyota", 2020, 15000, "Yaris", true
            );

            Vehiculo furgon1 = new Furgon(
                    "Mercedes-Benz", 2022, 40000, 2.0
            );

            System.out.println("=== COSTOS DE SERVICIO ===");

            System.out.println(auto1);
            System.out.println("Costo: $" + auto1.calcularCostoServicio());

            System.out.println(furgon1);
            System.out.println("Costo: $" + furgon1.calcularCostoServicio());

            System.out.println("=== COSTOS CON DESCUENTO ===");

            System.out.println("Auto con 10%: $"
                    + auto1.calcularCostoServicio(10));

            System.out.println("Furgón con 20%: $"
                    + furgon1.calcularCostoServicio(20));

            System.out.println("=== GARANTÍA DEL TALLER ===");

            Garantizable garantiaAuto = (Garantizable) auto1;

            // Compruebo el estado antes y después de activar la garantía.
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