package test;

import armas.Ariete;
import armas.Arma;
import armas.Catapulta;
import defesas.Castelo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasteloTest {
    @Test
    void testaCasteloQueDerrubaMuro(){
        Castelo castelo=new Castelo("Camelot");
        Arma ariete =new Ariete("Ariete",true);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);

        boolean estadoEsperado=false;
        boolean estadoObtido = castelo.verificaSeMuroEstaDePe();

        assertEquals(estadoEsperado,estadoObtido);
    }
    @Test
    void testaCasteloQueDerrubaMuroETomaNaDefesa(){
        Castelo castelo=new Castelo("Camelot");
        Arma ariete =new Ariete("Ariete",true);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);
        castelo.receberAtaque(ariete);

        int pontosDeDefesaEsperado=49000;
        int pontosDeDefesaObtido = castelo.getPontosDeDefesa();

        assertEquals(pontosDeDefesaEsperado,pontosDeDefesaObtido);
    }

    @Test
    void testaCasteloTomandoDanoAereo(){
        Castelo castelo=new Castelo("Camelot");
        Arma catapulta=new Catapulta("Catapulta.png",23200);
        castelo.receberAtaque(catapulta);

        int pontosDeDefesaEsperado = 100;
        int pontosDeDefesaObtido = castelo.getPontosDeDefesa();

        assertEquals(pontosDeDefesaEsperado,pontosDeDefesaObtido);
    }

    @Test
    void testaCasteloTomandoDanoAereoEMortal(){
        Castelo castelo=new Castelo("Camelot");
        Arma catapulta=new Catapulta("Catapulta.png",23250);
        castelo.receberAtaque(catapulta);

        int pontosDeDefesaEsperado = 0;
        int pontosDeDefesaObtido = castelo.getPontosDeDefesa();

        assertEquals(pontosDeDefesaEsperado,pontosDeDefesaObtido);
    }
    @Test
    void testaCasteloTomandoDanoAereoEMortalEChecandoSeEstaVivo(){
        Castelo castelo=new Castelo("Camelot");
        Arma catapulta=new Catapulta("Catapulta.png",23250);
        castelo.receberAtaque(catapulta);

        boolean estadoEsperado = false;
        boolean estadoObtido = castelo.veirifcaSeCasteloTaDePe();

        assertEquals(estadoEsperado,estadoObtido);
    }
}
