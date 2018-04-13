package jogo.pocoes;

import jogo.InventarioDeItens;
import jogo.Item;

public class Pocao extends Item {
    private int dose;
    private int pontosDeEfeito;


    public Pocao(String nome, double valor, int doses, int pontosDeEfeito) {
        super(nome, valor, doses*0.1);
        this.dose = doses;
        this.pontosDeEfeito = pontosDeEfeito;
    }

    public void gastarDose(){
        this.dose--;
        if(this.dose<1){
            getInventarioDeItensAquePertence().removerItem(this);
        }
    }
}
