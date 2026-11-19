package br.edu.unipe.kits;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimuladorTest {
    private final Simulador simulador = new Simulador();

    @Test
    void estufaAcionaBombaComSoloSeco() {
        Resultado esperado = new Resultado(
            new Leitura("Sensor de umidade", 25, "%", true), "Bomba de irrigação", "Ligada");
        assertEquals(esperado, simulador.executar(new FabricaEstufa()));
    }

    @Test
    void camaraAcionaCompressorComTemperaturaAlta() {
        Resultado esperado = new Resultado(
            new Leitura("Sensor de temperatura", 12, "°C", true), "Compressor", "Ligado");
        assertEquals(esperado, simulador.executar(new FabricaCamaraFria()));
    }
}
