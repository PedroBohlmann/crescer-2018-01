package tests;

import corredores.Corredor;
import corredores.Mario;
import org.junit.jupiter.api.Test;
import pistas.Casa;
import pistas.DonutPlains;
import pistas.Podium;

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
        for(int i=0;i<6;i++) {
            mario.andar();
        }

        Casa casa= donutPlains.getCasaOndeCorredorEsta(mario);
        assertEquals(4,casa.getNumeroDaCasa());
    }
}
