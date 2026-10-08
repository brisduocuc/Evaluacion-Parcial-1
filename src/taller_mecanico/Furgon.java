package taller_mecanico;

public class Furgon extends Vehiculo {

    private double capacidadCargaToneladas;

    public Furgon(String marca, int anioFabricacion, double kilometraje,
                  double capacidadCargaToneladas) {

        super(marca, anioFabricacion, kilometraje);

        setCapacidadCargaToneladas(capacidadCargaToneladas);
    }

    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }

    public void setCapacidadCargaToneladas(double capacidadCargaToneladas) {

        if (capacidadCargaToneladas <= 0
                || Double.isNaN(capacidadCargaToneladas)
                || Double.isInfinite(capacidadCargaToneladas)) {

            throw new IllegalArgumentException(
                    "La capacidad de carga debe ser mayor que cero"
            );

        } else {
            this.capacidadCargaToneladas = capacidadCargaToneladas;
        }
    }

    @Override
    public double calcularCostoServicio() {

        double costoBase = 35000;

        if (capacidadCargaToneladas > 1.5) {
            costoBase = costoBase * 1.25;
        }

        return costoBase;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}