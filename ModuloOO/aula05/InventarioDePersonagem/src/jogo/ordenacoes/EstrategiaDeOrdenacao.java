package jogo.ordenacoes;

import jogo.Item;

import java.util.Arrays;
import java.util.List;

public class EstrategiaDeOrdenacao {
    public List<Item> ordernar(List<Item> listaDeItens){
        Item arItem[]= listaDeItens.toArray(new Item[0]);
        for(int i=0; i < arItem.length; i++){
            for(int j=1; j < (arItem.length-i); j++){
                if(compara(arItem[j-1],arItem[j])){
                    Item temp = arItem[j-1];
                    arItem[j-1] = arItem[j];
                    arItem[j] = temp;
                }
            }
        }
        return Arrays.asList(arItem);
    }

    protected boolean compara(Item a,Item b){
        return a==b;
    }

}
