package br.edu.unipe.kits;

import java.util.Objects;

public class FabricaEstufa implements FabricaDeAutomacao {
    private final Cenario cenario;

    public FabricaEstufa() {
        this(Cenario.ALERTA);
    }

    public FabricaEstufa(Cenario cenario) {
        this.cenario = Objects.requireNonNull(cenario, "cenario");
    }

    @Override
    public Sensor criarSensor() {
        return new SensorUmidade(cenario);
    }

    @Override
    public Atuador criarAtuador() {
        return new BombaIrrigacao();
    }
}
