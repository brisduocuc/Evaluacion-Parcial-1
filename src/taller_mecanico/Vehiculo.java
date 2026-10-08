package taller_mecanico;

public class Vehiculo {
    private String marca;
    private int anioFabricacion;
    private double kilometraje;

    public Vehiculo(String marca, int anioFabricacion, double kilometraje) {
        setMarca(marca);
        setAnioFabricacion(anioFabricacion);
        setKilometraje(kilometraje);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("Marca inválida");
        } else {
            this.marca = marca;
        }
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 1990 || anioFabricacion > 2026) {
            throw new IllegalArgumentException("Año de fabricación no válido");
        } else {
            this.anioFabricacion = anioFabricacion;
        }
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        if (kilometraje <= 0 || Double.isNaN(kilometraje)
                || Double.isInfinite(kilometraje)) {
            throw new IllegalArgumentException("Kilometraje debe ser mayor que cero y válido");
        } else {
            this.kilometraje = kilometraje;
        }
    }

    @Override
    public String toString() {
        return "Vehiculo: " +
                "marca='" + marca + '\'' +
                ", anioFabricacion=" + anioFabricacion;
    }
}