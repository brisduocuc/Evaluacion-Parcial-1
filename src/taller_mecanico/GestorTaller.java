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

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMarca().equalsIgnoreCase(criterio)) {
                encontrados.add(vehiculo);
            }
        }

        return encontrados;
    }

    public void mostrarVehiculos() {

        System.out.println("=== VEHÍCULOS REGISTRADOS ===");

        // El listado utiliza el formato definido en Vehiculo.
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }

    public void mostrarDetalleVehiculos(List<Vehiculo> encontrados) {

        for (Vehiculo vehiculo : encontrados) {

            System.out.println("Tipo: "
                    + vehiculo.getClass().getSimpleName());

            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Año: " + vehiculo.getAnioFabricacion());
            System.out.println("Kilometraje: " + vehiculo.getKilometraje());

            // Los datos específicos dependen del vehículo encontrado.
            if (vehiculo instanceof Auto) {

                Auto auto = (Auto) vehiculo;

                System.out.println("Modelo: " + auto.getModelo());
                System.out.println("Garantía fábrica: "
                        + auto.isGarantiaFabricaVigente());

                System.out.println("Garantía activa: "
                        + auto.tieneGarantiaActiva());

            } else if (vehiculo instanceof Furgon) {

                Furgon furgon = (Furgon) vehiculo;

                System.out.println("Capacidad: "
                        + furgon.getCapacidadCargaToneladas()
                        + " toneladas");
            }

            System.out.println("Costo servicio: $"
                    + vehiculo.calcularCostoServicio());

            System.out.println();
        }
    }

    public List<Vehiculo> obtenerVehiculos() {
        return new ArrayList<>(vehiculos);
    }
}