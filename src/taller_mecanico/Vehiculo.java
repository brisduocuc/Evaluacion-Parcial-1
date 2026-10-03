package taller_mecanico;

public class Vehiculo {
    private String marca;
    private int anioFabricacion;
    private double kilometraje;

    public Vehiculo(String marca, int anioFabricacion, double kilometraje) {
//        this.marca = marca;
//        this.anioFabricacion = anioFabricacion;
//        this.kilometraje = kilometraje;
        setMarca(marca);
        setAnioFabricacion(anioFabricacion);
        setKilometraje(kilometraje);

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        try {
            if (marca == null || marca.trim().isEmpty()) {
                throw new IllegalArgumentException("Marca inválida");
            } else {
                this.marca = marca;
            }

        } catch (IllegalArgumentException e){
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        try {
            if (anioFabricacion >= 1990 && anioFabricacion <= 2026) {
                throw new IllegalArgumentException("Año de fabricación no válido");
            } else {
                this.anioFabricacion = anioFabricacion;
            }

        } catch (IllegalArgumentException e){
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        try {
            if (anioFabricacion > 0) {
                throw new IllegalArgumentException("Kilometraje debe ser mayor que cero");
            } else {
                this.kilometraje = kilometraje;
            }

        } catch (IllegalArgumentException e){
            System.out.println("Mensaje de error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Vehiculo:" +
                "marca='" + marca + '\'' +
                ", anioFabricacion=" + anioFabricacion;
    }
}
