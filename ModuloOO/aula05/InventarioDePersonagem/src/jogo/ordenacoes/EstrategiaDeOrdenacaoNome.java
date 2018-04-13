package jogo.ordenacoes;

import jogo.Item;

public class EstrategiaDeOrdenacaoNome extends EstrategiaDeOrdenacao {
    @Override
    protected boolean compara(Item a, Item b) {
        return (a.getNome().compareToIgnoreCase(b.getNome()))>0?true:false;
    }
}
