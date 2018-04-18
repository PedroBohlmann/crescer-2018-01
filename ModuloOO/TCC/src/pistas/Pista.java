package pistas;

import corredores.Corredor;

public class Pista {

    private int tamanho;

    public Pista(int tamanhoDaPista) {
        this.tamanho=tamanhoDaPista;
    }

    public void adicionarCorredor(Corredor novoCorredor) {
        novoCorredor.associarAUmaPista(this);
    }

    public int getTamanhoDaPista(){
        return tamanho;
    }

}
