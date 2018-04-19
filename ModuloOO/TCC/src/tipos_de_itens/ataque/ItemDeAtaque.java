package tipos_de_itens.ataque;

import corredores.Corredor;
import tipos_de_itens.Item;

public interface ItemDeAtaque extends Item {

    void usarAlvo(Corredor corredor);
}
