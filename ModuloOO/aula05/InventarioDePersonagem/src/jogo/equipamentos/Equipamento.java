package jogo.equipamentos;

import jogo.Item;

public class Equipamento extends Item {
    private int durabilidade;

    public Equipamento(String nome, double valor, double peso, int durabilidade) {
        super(nome, valor, peso);
        this.durabilidade = durabilidade;
    }

    public void  usar(){
        int durabilidadeUsada=this.getUsoDeDurabilidade();

        this.durabilidade-=durabilidadeUsada;
        if(this.durabilidade<=0){
            this.getInventarioDeItensAquePertence().removerItem(this);
        }
    }
    protected int getUsoDeDurabilidade(){
        return 0;
    }
}
