package taller_mecanico;

public abstract class Vehiculo {

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
            throw new IllegalArgumentException("Kilometraje inválido");
        } else {
            this.kilometraje = kilometraje;
        }
    }

    public abstract double calcularCostoServicio();

    public double calcularCostoServicio(double porcentajeDescuento) {

        if (Double.isNaN(porcentajeDescuento)
                || porcentajeDescuento < 0
                || porcentajeDescuento > 100) {
            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 100"
            );
        }

        double costoNormal = calcularCostoServicio();

        return costoNormal - (costoNormal * porcentajeDescuento / 100);
    }

    @Override
    public String toString() {
        return "Vehiculo: " +
                "marca='" + marca + '\'' +
                ", anioFabricacion=" + anioFabricacion;
    }
}