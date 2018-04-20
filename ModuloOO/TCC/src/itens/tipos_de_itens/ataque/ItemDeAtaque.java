package itens.tipos_de_itens.ataque;

import corredores.Corredor;
import itens.tipos_de_itens.Item;

public interface ItemDeAtaque extends Item {

    void usarAlvo(Corredor corredor);
}
