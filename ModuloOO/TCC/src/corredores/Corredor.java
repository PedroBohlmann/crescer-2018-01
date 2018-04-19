package corredores;

import pistas.Casa;
import pistas.Pista;

public abstract class Corredor {

    private int vida;
    private int quantidadeDeCasasQuePercorre;

    private Pista pistaQuePertence;
    private Casa casaAtual;

    public Corredor(int vida) {
        this.vida = vida;
        this.quantidadeDeCasasQuePercorre = 3;
    }

    public abstract void andar();/* {

    }*/


    public void associarAUmaPista(Pista pista) {
        this.pistaQuePertence = pista;
        this.casaAtual = new Casa(0);
    }

    public int getQuantidadeDeCasasQuePercorre() {
        return quantidadeDeCasasQuePercorre;
    }

    public Pista getPistaQuePertence() {
        return pistaQuePertence;
    }

    public Casa getCasaAtual() {
        return casaAtual;
    }

    protected void setCasaAtual(Casa casa){
        this.casaAtual=casa;
    }

    public int getVida() {
        return vida;
    }
}
