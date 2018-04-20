package itens;


import corredores.Corredor;
import itens.tipos_de_itens.uso.ItemDeBonus;

public class Cogumelo implements ItemDeBonus {

    private int bonus;

    public Cogumelo() {
        this.bonus = 4;
    }

    @Override
    public void darBonus(Corredor corredor) {
        corredor.andaUmNumeroEspecificoDeCasas(this.bonus);
    }

    @Override
    public void consumir(Corredor corredor) {
        darBonus(corredor);
    }
}
