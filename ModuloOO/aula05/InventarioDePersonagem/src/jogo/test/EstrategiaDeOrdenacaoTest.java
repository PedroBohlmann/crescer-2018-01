package jogo.test;

import jogo.InventarioDeItens;
import jogo.equipamentos.Armadura;
import jogo.equipamentos.Espada;
import jogo.ordenacoes.EstrategiaDeOrdenacaoPeso;
import jogo.ordenacoes.EstrategiaDeOrdenacaoValor;
import jogo.pocoes.PocaoDeCura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstrategiaDeOrdenacaoTest {
    @Test
    public void testaEstrategiaComQuatroItensConsiderandoOPeso(){
        Espada espada=new Espada();
        Armadura armadura=new Armadura();
        PocaoDeCura pocaoDeCura=new PocaoDeCura(2);
        InventarioDeItens inventarioDeItens = new InventarioDeItens();

        inventarioDeItens.adicionarItem(espada);
        inventarioDeItens.adicionarItem(armadura);
        inventarioDeItens.adicionarItem(pocaoDeCura);

        inventarioDeItens.ordernar(new EstrategiaDeOrdenacaoPeso());
        double pesoEsperado=6.5;
        double pesoObtido=inventarioDeItens.getListaDeItens().get(0).getPeso();
        assertEquals(pesoEsperado,pesoObtido);
    }

    @Test
    public void testaEstrategiaComQuatroItensConsiderandoOValor(){
        Espada espada=new Espada();
        Armadura armadura=new Armadura();
        PocaoDeCura pocaoDeCura=new PocaoDeCura(2);

        InventarioDeItens inventarioDeItens = new InventarioDeItens();
        inventarioDeItens.adicionarItem(espada);
        inventarioDeItens.adicionarItem(armadura);
        inventarioDeItens.adicionarItem(pocaoDeCura);

        inventarioDeItens.ordernar(new EstrategiaDeOrdenacaoValor());
        double precoEsperado=80;
        double precoObtido=inventarioDeItens.getListaDeItens().get(0).getValor();
        assertEquals(precoEsperado,precoObtido);
    }
    @Test
    public void testaEstrategiaComQuatroItensConsiderandoONome(){
        Espada espada=new Espada();
        Armadura armadura=new Armadura();
        PocaoDeCura pocaoDeCura=new PocaoDeCura(2);

        InventarioDeItens inventarioDeItens = new InventarioDeItens();
        inventarioDeItens.adicionarItem(espada);
        inventarioDeItens.adicionarItem(armadura);
        inventarioDeItens.adicionarItem(pocaoDeCura);

        inventarioDeItens.ordernar(new jogo.ordenacoes.EstrategiaDeOrdenacaoNome());
        String nomeEsperado="Armadura";
        String nomeObtido=inventarioDeItens.getListaDeItens().get(0).getNome();
        assertEquals(nomeEsperado,nomeObtido);
    }
}
