package tipos_de_itens.uso;

import corredores.Corredor;
import tipos_de_itens.Item;

public interface ItemDeUso extends Item {

    void consumir(Corredor corredor);

}
