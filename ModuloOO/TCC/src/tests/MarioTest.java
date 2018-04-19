package tests;

import corredores.Mario;
import org.junit.jupiter.api.Test;
import pistas.casas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarioTest {

    @Test
    public void marioComecaCom7DeVida(){
        Mario mario = new Mario();

        assertEquals(7,mario.getVida());
    }

    @Test
    public void marioAnda4Casas(){
        DonutPlains donutPlains=new DonutPlains();
        Mario mario=new Mario();

        donutPlains.adicionarCorredor(mario);

        mario.andar();

        Casa casa= donutPlains.getCasaOndeCorredorEsta(mario);
        assertEquals(4,casa.getNumeroDaCasa());
    }
}
