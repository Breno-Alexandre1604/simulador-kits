package br.edu.unipe.kits;

public class BombaIrrigacao implements Atuador {
    @Override
    public String nome() {
        return "Bomba de irrigação";
    }

    @Override
    public String aplicar(boolean ligar) {
        return ligar ? "Ligada" : "Desligada";
    }
}
