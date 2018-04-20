package itens;

import corredores.Corredor;
import itens.tipos_de_itens.ataque.ItemDeAtaque;
import itens.tipos_de_itens.uso.ItemDeBonus;


public class Baletao implements ItemDeBonus, ItemDeAtaque {

    private int bonus;
    private int dano;

    public Baletao() {
        this.bonus = 7;
        this.dano = 5;
    }

    @Override
    public void usarAlvo(Corredor corredor) {
        corredor.recebeDano(this.dano);
    }

    @Override
    public void darBonus(Corredor corredor) {
        corredor.andaUmNumeroEspecificoDeCasas(this.bonus);
    }

    @Override
    public void consumir(Corredor corredor) {
        this.darBonus(corredor);
    }
}
