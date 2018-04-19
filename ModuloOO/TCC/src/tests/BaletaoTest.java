package tests;

import corredores.Luigi;
import corredores.Mario;
import exceptions.AlvoInvalidoException;
import exceptions.ItemInvalidoException;
import itens.Baletao;
import org.junit.jupiter.api.Test;
import pistas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaletaoTest {

    @Test
    public void baletaoAnda7Casas() throws ItemInvalidoException {
        Luigi luigi = new Luigi();
        Baletao baletao = new Baletao();
        DonutPlains donutPlains = new DonutPlains();

        donutPlains.adicionarCorredor(luigi);

        luigi.equiparItem(baletao);
        luigi.usarItem(baletao);

        Casa casaObtido = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(7, casaObtido.getNumeroDaCasa());
    }

    @Test
    public void baletaoCausa5DeDano() throws AlvoInvalidoException, ItemInvalidoException {
        Luigi luigi = new Luigi();
        Mario mario = new Mario();
        Baletao baletao = new Baletao();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(luigi);

        mario.equiparItem(baletao);
        mario.usarItem(baletao, luigi);

        assertEquals(0, luigi.getVida());

    }
}
