package jogo;

import jogo.equipamentos.Equipamento;
import jogo.ordenacoes.EstrategiaDeOrdenacao;

import java.util.LinkedList;
import java.util.List;

public class InventarioDeItens {
    private List<Item> listaDeItens;

    public InventarioDeItens() {
        this.listaDeItens=new LinkedList<>();//Bom para lista mutavel
    }
    public void adicionarItem(Item item){
        this.listaDeItens.add(item);
        item.vincularAInventario(this);
    }
    public void removerItem(Item item){
        this.listaDeItens.remove(item);

    }
    public List<Item> getListaDeItens(){
        return listaDeItens;
    }

    public List<Equipamento> getEquipamentos(){
        LinkedList<Equipamento> listaFiltrada=new LinkedList<>();
        for(Item itemNaLista:this.listaDeItens){
            if(itemNaLista instanceof Equipamento){
                listaFiltrada.add((Equipamento) itemNaLista);
            }
        }
        return listaFiltrada;
    }

    public void ordernar(EstrategiaDeOrdenacao estrategiaDeOrdenacao){
        this.listaDeItens=estrategiaDeOrdenacao.ordernar(listaDeItens);
        ;
    }
}
