package br.edu.unipe.kits;

public class SensorTemperatura implements Sensor {
    @Override
    public Leitura medir() {
        int valor = 12;
        return new Leitura("Sensor de temperatura", valor, "°C", valor > 8);
    }
}
