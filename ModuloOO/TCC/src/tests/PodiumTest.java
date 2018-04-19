package tests;

import corredores.Luigi;
import corredores.Mario;
import org.junit.jupiter.api.Test;
import pistas.DonutPlains;
import pistas.Podium;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PodiumTest {
    @Test
    public void corredorTerminaEmSegundoLugar() {
        DonutPlains donutPlains = new DonutPlains();
        Mario mario = new Mario();
        Luigi luigi = new Luigi();


        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(luigi);

        for (int i = 0; i < 6; i++) {
            mario.andar();
        }

        for (int i = 0; i < 7; i++) {
            luigi.andar();
        }

        assertEquals(mario, donutPlains.getCorredorNaPosicao(Podium.PRIMEIRO_LUGAR));
        assertEquals(luigi, donutPlains.getCorredorNaPosicao(Podium.SEGUNDO_LUGAR));
    }
}
