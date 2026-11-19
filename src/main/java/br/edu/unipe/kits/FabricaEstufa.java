package br.edu.unipe.kits;

public class FabricaEstufa implements FabricaDeAutomacao {
    @Override
    public Sensor criarSensor() {
        return new SensorUmidade();
    }

    @Override
    public Atuador criarAtuador() {
        return new BombaIrrigacao();
    }
}
