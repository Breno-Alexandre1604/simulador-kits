package br.edu.unipe.kits;

public class SensorTemperatura implements Sensor {
    private final int valor;

    public SensorTemperatura() {
        this(Cenario.ALERTA);
    }

    public SensorTemperatura(Cenario cenario) {
        this.valor = switch (cenario) {
            case NORMAL -> 4;
            case ALERTA -> 12;
        };
    }

    @Override
    public Leitura medir() {
        return new Leitura("Sensor de temperatura", valor, "°C", valor > 8);
    }
}
