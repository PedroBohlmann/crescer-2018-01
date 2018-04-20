package pistas.casas;

import corredores.Corredor;
import itens.tipos_de_itens.Item;

public class CasaItem extends CasaCustomizada {

    private Item itemArmazenado;

    public CasaItem(int numeroDaCasa, Item item) {
        super(numeroDaCasa);
        itemArmazenado = item;
    }

    @Override
    public void aplicaEfeitoNoCorredor(Corredor corredor) {
        corredor.equiparItem(itemArmazenado);
        itemArmazenado = null;
    }
}
