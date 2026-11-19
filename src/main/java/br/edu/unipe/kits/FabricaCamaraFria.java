package br.edu.unipe.kits;

import java.util.Objects;

public class FabricaCamaraFria implements FabricaDeAutomacao {
    private final Cenario cenario;

    public FabricaCamaraFria() {
        this(Cenario.ALERTA);
    }

    public FabricaCamaraFria(Cenario cenario) {
        this.cenario = Objects.requireNonNull(cenario, "cenario");
    }

    @Override
    public Sensor criarSensor() {
        return new SensorTemperatura(cenario);
    }

    @Override
    public Atuador criarAtuador() {
        return new Compressor();
    }
}
