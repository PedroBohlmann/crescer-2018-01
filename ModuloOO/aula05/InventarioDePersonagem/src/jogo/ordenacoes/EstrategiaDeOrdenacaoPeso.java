package jogo.ordenacoes;

import jogo.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EstrategiaDeOrdenacaoPeso extends EstrategiaDeOrdenacao {
    @Override
    public List<Item> ordernar(List<Item> listaDeItens) {
        Item arItem[]= (Item[]) listaDeItens.toArray();
        return listaDeItens;
    }
}
