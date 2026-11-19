package br.edu.unipe.kits;

public class Simulador {
    public Resultado executar(FabricaDeAutomacao fabrica) {
        Sensor sensor = fabrica.criarSensor();
        Atuador atuador = fabrica.criarAtuador();
        Leitura leitura = sensor.medir();
        String estado = atuador.aplicar(leitura.requerAcao());
        return new Resultado(leitura, atuador.nome(), estado);
    }
}
