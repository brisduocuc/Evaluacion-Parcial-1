package taller_mecanico;

public class Auto extends Vehiculo {

    private String modelo;
    private boolean garantiaFabricaVigente;

    public Auto(String marca, int anioFabricacion, double kilometraje,
                String modelo, boolean garantiaFabricaVigente) {

        super(marca, anioFabricacion, kilometraje);

        setModelo(modelo);
        setGarantiaFabricaVigente(garantiaFabricaVigente);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        // Valido que el modelo tenga algún valor
        // para no guardar uno vacío.
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo inválido");
        } else {
            this.modelo = modelo;
        }
    }

    public boolean isGarantiaFabricaVigente() {
        return garantiaFabricaVigente;
    }

    public void setGarantiaFabricaVigente(boolean garantiaFabricaVigente) {
        this.garantiaFabricaVigente = garantiaFabricaVigente;
    }

    @Override
    public double calcularCostoServicio() {

        double costoBase = 25000;

        if (!garantiaFabricaVigente) {
            costoBase = costoBase * 1.30;
        }

        return costoBase;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}