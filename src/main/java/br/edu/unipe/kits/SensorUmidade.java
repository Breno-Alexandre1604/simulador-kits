package br.edu.unipe.kits;

public class SensorUmidade implements Sensor {
    private final int valor;

    public SensorUmidade() {
        this(Cenario.ALERTA);
    }

    public SensorUmidade(Cenario cenario) {
        this(switch (cenario) {
            case NORMAL -> 55;
            case ALERTA -> 25;
        });
    }

    SensorUmidade(int valor) {
        this.valor = valor;
    }

    @Override
    public Leitura medir() {
        return new Leitura("Sensor de umidade", valor, "%", valor < 40);
    }
}
