package test;

import org.junit.jupiter.api.Test;
import produtos.Artigo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArtigoTest {
    @Test
    void testaCriacaoArtigo(){
        Artigo artigo=new Artigo(200,0.10,"Nitro","Super Fast");
        double valorTotalEsperado=248.6;
        double valorTotalObtido=artigo.calcularValorTotal();

        assertEquals(valorTotalEsperado,valorTotalObtido);
    }
}