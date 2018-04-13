package test;

import armas.Arma;
import armas.Catapulta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultaTest {
    @Test
    void testaCatapultaCom1000DeAltura(){
        Arma catapulta=new Catapulta("Catapulta",1000);
        int danoEsperado=5500;
        int danoObtido=catapulta.getPoderDeAtaque();

        assertEquals(danoEsperado,danoObtido);
    }
    @Test
    void testaCatapultaCom2000DeAltura(){
        Arma catapulta=new Catapulta("Catapulta",2000);
        int danoEsperado=7500;
        int danoObtido=catapulta.getPoderDeAtaque();

        assertEquals(danoEsperado,danoObtido);
    }

}
