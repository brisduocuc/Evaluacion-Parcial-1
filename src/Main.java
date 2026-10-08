import taller_mecanico.Vehiculo;
import taller_mecanico.Auto;
import taller_mecanico.Furgon;

public class Main {

    public static void main(String[] args) {

        try {

            // Creo un auto con garantía vigente.
            Vehiculo auto1 = new Auto(
                    "Toyota", 2020, 15000, "Yaris", true
            );

            // Creo un auto sin garantía vigente.
            Vehiculo auto2 = new Auto(
                    "Hyundai", 2018, 80000, "Accent", false
            );

            // Creo un furgón que supera las 1.5 toneladas.
            Vehiculo furgon1 = new Furgon(
                    "Mercedes-Benz", 2022, 40000, 2.0
            );

            // Creo otro furgón con capacidad menor.
            Vehiculo furgon2 = new Furgon(
                    "Peugeot", 2021, 35000, 1.2
            );

            System.out.println("=== COSTOS DE SERVICIO ===");

            System.out.println(auto1);
            System.out.println("Costo: $" + auto1.calcularCostoServicio());

            System.out.println();

            System.out.println(auto2);
            System.out.println("Costo: $" + auto2.calcularCostoServicio());

            System.out.println();

            System.out.println(furgon1);
            System.out.println("Costo: $" + furgon1.calcularCostoServicio());

            System.out.println();

            System.out.println(furgon2);
            System.out.println("Costo: $" + furgon2.calcularCostoServicio());

            System.out.println();
            System.out.println("=== COSTOS CON DESCUENTO ===");

            System.out.println("Auto con 10%: $"
                    + auto1.calcularCostoServicio(10));

            System.out.println("Furgón con 20%: $"
                    + furgon1.calcularCostoServicio(20));

        } catch (IllegalArgumentException e) {

            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }
}