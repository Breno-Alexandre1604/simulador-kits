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

    @Test
    void estufaMantemBombaDesligadaNoCenarioNormal() {
        Resultado esperado = new Resultado(
            new Leitura("Sensor de umidade", 55, "%", false), "Bomba de irrigação", "Desligada");
        assertEquals(esperado, simulador.executar(new FabricaEstufa(Cenario.NORMAL)));
    }

    @Test
    void camaraMantemCompressorDesligadoNoCenarioNormal() {
        Resultado esperado = new Resultado(
            new Leitura("Sensor de temperatura", 4, "°C", false), "Compressor", "Desligado");
        assertEquals(esperado, simulador.executar(new FabricaCamaraFria(Cenario.NORMAL)));
    }

    @Test
    void bombaFicaDesligadaComUmidadeDe40PorCento() {
        Leitura leitura = new SensorUmidade(40).medir();
        assertEquals(new Leitura("Sensor de umidade", 40, "%", false), leitura);
        assertEquals("Desligada", new BombaIrrigacao().aplicar(leitura.requerAcao()));
    }

    @Test
    void compressorFicaDesligadoComTemperaturaDe8Graus() {
        Leitura leitura = new SensorTemperatura(8).medir();
        assertEquals(new Leitura("Sensor de temperatura", 8, "°C", false), leitura);
        assertEquals("Desligado", new Compressor().aplicar(leitura.requerAcao()));
    }
}
