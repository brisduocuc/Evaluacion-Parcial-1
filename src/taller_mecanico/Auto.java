package taller_mecanico;

public class Auto extends Vehiculo implements Garantizable {

    private String modelo;
    private boolean garantiaFabricaVigente;
    private boolean garantiaActiva = false;

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

        // Sin garantía de fábrica, el servicio aumenta un 30%.
        if (!garantiaFabricaVigente) {
            costoBase = costoBase * 1.30;
        }

        return costoBase;
    }

    @Override
    public boolean tieneGarantiaActiva() {
        return garantiaActiva;
    }

    @Override
    public void activarGarantia() {
        garantiaActiva = true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}