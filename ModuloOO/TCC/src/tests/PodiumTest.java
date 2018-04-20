package tests;

import corredores.Bowser;
import corredores.Luigi;
import corredores.Mario;
import corredores.Peach;
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

        for (int i = 0; i < 5; i++) {
            mario.andar();
        }

        for (int i = 0; i < 7; i++) {
            luigi.andar();
        }

        assertEquals(mario, donutPlains.getCorredorNaPosicao(Podium.PRIMEIRO_LUGAR));
        assertEquals(luigi, donutPlains.getCorredorNaPosicao(Podium.SEGUNDO_LUGAR));
    }

    @Test
    public void corredoresCompletamOPodiumMasUmFicaFora() {
        DonutPlains donutPlains = new DonutPlains();
        Mario mario = new Mario();
        Luigi luigi = new Luigi();
        Peach peach = new Peach();
        Bowser bowser = new Bowser();


        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(peach);
        donutPlains.adicionarCorredor(bowser);

        for (int i = 0; i < 5; i++) {
            mario.andar();
        }

        for (int i = 0; i < 7; i++) {
            luigi.andar();
        }

        for (int i = 0; i < 7; i++) {
            peach.andar();
        }

        for (int i = 0; i < 7; i++) {
            bowser.andar();
        }

        assertEquals(mario, donutPlains.getCorredorNaPosicao(Podium.PRIMEIRO_LUGAR));
        assertEquals(luigi, donutPlains.getCorredorNaPosicao(Podium.SEGUNDO_LUGAR));
        assertEquals(peach, donutPlains.getCorredorNaPosicao(Podium.TERCEIRO_LUGAR));
    }
}
