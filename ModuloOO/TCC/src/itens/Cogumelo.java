package itens;


import corredores.Corredor;
import tipos_de_itens.uso.ItemDeBonus;

public class Cogumelo implements ItemDeBonus {

    private int bonus;

    public Cogumelo() {
        this.bonus = 4;
    }

    @Override
    public void darBonus(Corredor corredor) {
        corredor.recebeBonus(this.bonus);
    }

    @Override
    public void consumir(Corredor corredor) {
        darBonus(corredor);
    }
}
