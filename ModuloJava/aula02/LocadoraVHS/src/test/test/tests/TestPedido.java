package tests;

import models.Cliente;
import models.Filme;
import models.Fita;
import models.Pedido;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPedido {
    @Test
    public void testaAdicionando(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", 5, 3);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        pedido.adicionaFita(fita1);
        pedido.adicionaFita(fita2);
        pedido.adicionaFita(fita3);

        assertEquals(fita1,pedido.getFitas().get(0));
        assertEquals(fita2,pedido.getFitas().get(1));
        assertEquals(fita3,pedido.getFitas().get(2));
    }

    @Test
    public void testaCalculoDoValorTotal(){
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        Filme filme = new Filme("Rei leão", 5, 3);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        pedido.adicionaFita(fita1);
        pedido.adicionaFita(fita2);
        pedido.adicionaFita(fita3);

        assertEquals(15,pedido.getValorTotal(),0.001);
    }

    @Test
    public void testaCalculoDoValorTotalSemFitas(){

        Cliente cliente = new Cliente("Pedro","111111111111");

        Pedido pedido = new Pedido(1,cliente);

        assertEquals(0,pedido.getValorTotal(),0.001);
    }
}
