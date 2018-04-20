package tests;

import corredores.Luigi;
import org.junit.jupiter.api.Test;
import pistas.casas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LuigiTest {
    @Test
    public void luigiTem5DeVida() {
        Luigi luigi = new Luigi();
        assertEquals(5, luigi.getVida());
    }

    @Test
    public void luigiAnda6CasasQuandoAndaDuasVezesNaDonutPlains() {
        Luigi luigi = new Luigi();
        DonutPlains donutPlains = new DonutPlains();

        donutPlains.adicionarCorredor(luigi);

        luigi.andar();
        luigi.andar();

        Casa casa = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(6, casa.getNumeroDaCasa());
    }
}
