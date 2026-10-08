package taller_mecanico;

import java.util.ArrayList;
import java.util.List;

public class GestorTaller {

    private List<Vehiculo> vehiculos;

    public GestorTaller() {
        vehiculos = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado correctamente");
    }

    public List<Vehiculo> buscarPorMarca(String criterio) {

        List<Vehiculo> encontrados = new ArrayList<>();

        // Recorro los vehículos para buscar los de la misma marca.
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMarca().equalsIgnoreCase(criterio)) {
                encontrados.add(vehiculo);
            }
        }

        return encontrados;
    }

    public void mostrarVehiculos() {

        System.out.println("=== VEHÍCULOS REGISTRADOS ===");

        // Cada vehículo calcula el costo según su tipo.
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
            System.out.println("Costo servicio: $"
                    + vehiculo.calcularCostoServicio());
            System.out.println();
        }
    }
}