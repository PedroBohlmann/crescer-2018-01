package itens.tipos_de_itens.ataque;

import corredores.Corredor;
import exceptions.AlvoInvalidoException;
import itens.tipos_de_itens.Item;

public interface ItemDeAtaque extends Item {

    void usarAlvo(Corredor corredorQueUsouItem,Corredor alvo) throws AlvoInvalidoException;
}
