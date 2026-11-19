package br.edu.unipe.kits;

public class FabricaCamaraFria implements FabricaDeAutomacao {
    @Override
    public Sensor criarSensor() {
        return new SensorTemperatura();
    }

    @Override
    public Atuador criarAtuador() {
        return new Compressor();
    }
}
