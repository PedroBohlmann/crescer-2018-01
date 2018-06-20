package tests;

import dominio.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestLocadora {
    @Test
    public void testLocadoraRealizaPedido(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão",Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Locadora locadora = new Locadora();

        locadora.adicionarFilme(filme);

        locadora.cadastrarCliente(cliente);

        locadora.realizaPedido(filme.getTitulo(),cliente.getCpf());

        assertEquals(0,locadora.getPedidos().get(0).getIdPedido());
        assertEquals(cliente.getCpf(),locadora.getPedidos().get(0).getCliente().getCpf());
        assertEquals(10,locadora.getPedidos().get(0).getValorTotal(),0.001);
    }

    @Test
    public void testLocadoraRealizaPedidoComPedidoExistente(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Locadora locadora = new Locadora();

        locadora.adicionarFilme(filme);
        locadora.adicionarFilme(filme2);

        locadora.cadastrarCliente(cliente);

        locadora.realizaPedido(filme.getTitulo(),cliente.getCpf());
        locadora.realizaPedido(filme2.getTitulo(),cliente.getCpf());


        assertEquals(0,locadora.getPedidos().get(0).getIdPedido());
        assertEquals(cliente.getCpf(),locadora.getPedidos().get(0).getCliente().getCpf());
        assertEquals(13,locadora.getPedidos().get(0).getValorTotal(),0.001);
    }

    @Test
    public void testLocadoraRealizaPedidoComPedidoExistenteEMultiplosTitulos(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Locadora locadora = new Locadora();

        locadora.adicionarFilme(filme);
        locadora.adicionarFilme(filme2);

        locadora.cadastrarCliente(cliente);

        List<String> listaDeTitulos = new ArrayList<>();

        listaDeTitulos.add(filme.getTitulo());
        listaDeTitulos.add(filme2.getTitulo());

        locadora.realizaPedido(listaDeTitulos,cliente.getCpf());


        assertEquals(0,locadora.getPedidos().get(0).getIdPedido());
        assertEquals(cliente.getCpf(),locadora.getPedidos().get(0).getCliente().getCpf());
        assertEquals(13,locadora.getPedidos().get(0).getValorTotal(),0.001);
    }

    @Test
    public void testDevolveFita(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", Categoria.DOURADA);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Filme filme2 = new Filme("Todo mundo odeia o cris", Categoria.BRONZE);

        Fita fita1Nova = new Fita();
        filme2.adicionaFita(fita1Nova);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Locadora locadora = new Locadora();

        locadora.adicionarFilme(filme);
        locadora.adicionarFilme(filme2);

        locadora.cadastrarCliente(cliente);

        List<String> listaDeTitulos = new ArrayList<>();

        listaDeTitulos.add(filme.getTitulo());
        listaDeTitulos.add(filme2.getTitulo());

        locadora.realizaPedido(listaDeTitulos,cliente.getCpf());


        assertEquals(0,locadora.getPedidos().get(0).getIdPedido());
        assertEquals(cliente.getCpf(),locadora.getPedidos().get(0).getCliente().getCpf());
        assertEquals(13,locadora.getPedidos().get(0).getValorTotal(),0.001);

        locadora.devolveFita(fita1,cliente);

        assertEquals(0,locadora.getPedidos().get(0).getIdPedido());
        assertEquals(cliente.getCpf(),locadora.getPedidos().get(0).getCliente().getCpf());
        assertEquals(3,locadora.getPedidos().get(0).getValorTotal(),0.001);
    }
}
