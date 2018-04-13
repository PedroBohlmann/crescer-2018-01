package jogo.ordenacoes;

import jogo.Item;

public class EstrategiaDeOrdenacaoValor extends EstrategiaDeOrdenacao{
    @Override
    protected boolean compara(Item a, Item b) {
        return a.getValor()>b.getValor();
    }
}
