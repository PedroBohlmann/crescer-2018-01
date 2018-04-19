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

    public void andar(){
        Pista pista = this.getPistaQuePertence();
        Casa casa = this.getCasaAtual();
        int quantidadeDeCasas = casaASerPercorrido();
        if (pista != null) {
            int numeroDaCasaAtual = casa.getNumeroDaCasa();
            if(numeroDaCasaAtual+quantidadeDeCasas>=pista.getTamanhoDaPista()){
                setCasaAtual(new Casa(pista.getTamanhoDaPista()));
                pista.adicionarAoPodium(this);
            }else{
                setCasaAtual(new Casa(numeroDaCasaAtual+quantidadeDeCasas));
            }
        }
    }

    protected abstract int casaASerPercorrido();

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
