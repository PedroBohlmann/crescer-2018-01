package tests;

import dominio.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

        List<Fita> fitas = new ArrayList<>();

        fitas.add(fita1);
        fitas.add(fita2);
        fitas.add(fita3);

        pedido.adicionarFitas(fitas);

        assertEquals(fita1,pedido.getLocacoes().get(0).getFita());
        assertEquals(fita2,pedido.getLocacoes().get(1).getFita());
        assertEquals(fita3,pedido.getLocacoes().get(2).getFita());
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

        List<Fita> fitas = new ArrayList<>();

        fitas.add(fita1);
        fitas.add(fita1Nova);

        pedido.adicionarFitas(fitas);

        assertEquals(13,pedido.getValorTotal(),0.001);
    }

    @Test
    public void testaCalculoDoValorTotalSemFitas(){

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        assertEquals(0,pedido.getValorTotal(),0.001);
    }

    @Test
    public void testaStatusPedido(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        List<Fita> fitas = new ArrayList<>();

        fitas.add(fita1);
        fitas.add(fita1Nova);

        pedido.adicionarFitas(fitas);

        assertEquals(StatusPedido.PENDENTE,pedido.getStatus());
        assertEquals(2,pedido.getLocacoes().size());
    }

    @Test
    public void testaStatusPedidoTentandoColocarMaisFitasSendoQueEleEstaPendente(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        List<Fita> fitas = new ArrayList<>();

        fitas.add(fita1);
        fitas.add(fita1Nova);

        pedido.adicionarFitas(fitas);

        assertEquals(StatusPedido.PENDENTE,pedido.getStatus());
        assertEquals(2,pedido.getLocacoes().size());

        pedido.adicionaFita(fita2);

        assertEquals(StatusPedido.PENDENTE,pedido.getStatus());
        assertEquals(2,pedido.getLocacoes().size());
    }

    @Test
    public void testaStatusEntregandoTodasFitas(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        List<Fita> fitas = new ArrayList<>();

        fitas.add(fita1);
        fitas.add(fita1Nova);

        pedido.adicionarFitas(fitas);

        assertEquals(StatusPedido.PENDENTE,pedido.getStatus());
        assertEquals(2,pedido.getLocacoes().size());

        pedido.devolveFita(fita1);

        assertEquals(StatusPedido.PENDENTE,pedido.getStatus());

        pedido.devolveFita(fita1Nova);

        assertEquals(StatusPedido.FECHADO,pedido.getStatus());
    }
}
