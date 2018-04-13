package test;

import armas.Ariete;
import armas.Arma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArieteTest {
    @Test
    void testaAriteComPontaDeFerro(){
        Arma ariete=new Ariete("Ariete", true);
        int danoEsperado = 1000;
        int danoObtido= ariete.getPoderDeAtaque();

        assertEquals(danoEsperado,danoObtido);
    }
    @Test
    void testaAriteSemPontaDeFerro(){
        Arma ariete=new Ariete("Ariete", false);
        int danoEsperado = 500;
        int danoObtido= ariete.getPoderDeAtaque();

        assertEquals(danoEsperado,danoObtido);
    }
}
