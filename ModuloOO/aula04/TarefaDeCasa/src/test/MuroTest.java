package test;

import armas.Ariete;
import armas.Arma;
import armas.Catapulta;
import defesas.Muro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuroTest {
    @Test
    void testaMuroRecebendoAtaqueDeCatapulta(){
        Arma catapulta=new Catapulta("Catapulta",1000);
        Muro muro=new Muro();
        int pontosDeDefesaEsperado=4500;
        muro.recebeAtaque(catapulta);
        int pontosDeDefesaObtido=muro.getPontosDeDefesa();

        assertEquals(pontosDeDefesaEsperado,pontosDeDefesaObtido);
    }
    @Test
    void testaMuroRecebendoAtaqueDeAriete(){
        Arma ariete=new Ariete("Ariete",true);
        Muro muro=new Muro();
        int pontosDeDefesaEsperado=9000;
        muro.recebeAtaque(ariete);
        int pontosDeDefesaObtido=muro.getPontosDeDefesa();

        assertEquals(pontosDeDefesaEsperado,pontosDeDefesaObtido);
    }
}
