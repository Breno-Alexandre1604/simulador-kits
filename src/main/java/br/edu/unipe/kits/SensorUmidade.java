package br.edu.unipe.kits;

public class SensorUmidade implements Sensor {
    @Override
    public Leitura medir() {
        int valor = 25;
        return new Leitura("Sensor de umidade", valor, "%", valor < 40);
    }
}
