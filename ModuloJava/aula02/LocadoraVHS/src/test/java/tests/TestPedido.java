package tests;

import dominio.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPedido {
    @Test
    public void testaAdicionando(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        pedido.adicionaFita(fita1);
        pedido.adicionaFita(fita2);
        pedido.adicionaFita(fita3);

        assertEquals(fita1,pedido.getLocacaos().get(0).getFita());
        assertEquals(fita2,pedido.getLocacaos().get(1).getFita());
        assertEquals(fita3,pedido.getLocacaos().get(2).getFita());
    }

    @Test
    public void testaCalculoDoValorTotal(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        pedido.adicionaFita(fita1);
        pedido.adicionaFita(fita1Nova);

        assertEquals(13,pedido.getValorTotal(),0.001);
    }

    @Test
    public void testaCalculoDoValorTotalSemFitas(){

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        assertEquals(0,pedido.getValorTotal(),0.001);
    }
}
