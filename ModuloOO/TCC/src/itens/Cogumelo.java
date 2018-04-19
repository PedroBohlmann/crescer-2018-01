package itens;


import corredores.Corredor;
import tipos_de_itens.uso.ItemDeBonus;

public class Cogumelo implements ItemDeBonus {

    private int bonus;

    public Cogumelo() {
        this.bonus = 4;
    }

    @Override
    public void usar(Corredor corredor) {
        corredor.recebeBonus(this.bonus);
    }
}
