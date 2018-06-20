package tests;

import models.Filme;
import models.Fita;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class TestFilme {
    @Test
    public void testaPrimeiraFitaNaoAlocada() {
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        fita2.loca();
        fita3.loca();

        Filme filme = new Filme("Rei leão", 5, 3);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Fita resultado = filme.primeiraFitaNaoLocada();

        assertEquals(fita1, resultado);
    }

    @Test
    public void testaPrimeiraFitaNaoAlocadaSendoQueSoSegundaEValida() {
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        fita1.loca();
        fita3.loca();

        Filme filme = new Filme("Rei leão", 5, 3);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Fita resultado = filme.primeiraFitaNaoLocada();

        assertEquals(fita2, resultado);
    }

    @Test(expected = RuntimeException.class)
    public void testaPrimeiraFitaNaoAlocadaSendoNenhumaEValida() {
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();

        fita1.loca();
        fita2.loca();
        fita3.loca();

        Filme filme = new Filme("Rei leão", 5, 3);

        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        Fita resultado = filme.primeiraFitaNaoLocada();
    }

    @Test
    public void testaAdicionaFitaETestaSeSetouOFilme() {
        Fita fita1 = new Fita();
        Fita fita2 = new Fita();
        Fita fita3 = new Fita();


        Filme filme = new Filme("Rei leão", 5, 3);
        filme.adicionaFita(fita1);
        filme.adicionaFita(fita2);
        filme.adicionaFita(fita3);

        assertEquals(filme, fita1.getFilme());
        assertEquals(filme, fita2.getFilme());
        assertEquals(filme, fita3.getFilme());
    }
}
