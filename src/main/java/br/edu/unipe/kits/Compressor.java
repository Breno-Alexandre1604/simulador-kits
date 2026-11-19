package br.edu.unipe.kits;

public class Compressor implements Atuador {
    @Override
    public String nome() {
        return "Compressor";
    }

    @Override
    public String aplicar(boolean ligar) {
        return ligar ? "Ligado" : "Desligado";
    }
}
