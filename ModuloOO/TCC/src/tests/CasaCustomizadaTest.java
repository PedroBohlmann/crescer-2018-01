package tests;

import corredores.Luigi;
import corredores.Peach;
import itens.CascoVerde;
import org.junit.jupiter.api.Test;
import pistas.RainbowRoad;
import pistas.casas.Casa;
import pistas.casas.CasaBuraco;
import pistas.casas.CasaItem;
import pistas.casas.CasaTurbo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasaCustomizadaTest {

    @Test
    public void caiNaCasa5Toma3DeDano() {
        Luigi luigi = new Luigi();
        CasaBuraco casaBuraco = new CasaBuraco(5);

        assertEquals(5, luigi.getVida());

        casaBuraco.adicionarCorredor(luigi);

        assertEquals(2, luigi.getVida());
    }

    @Test
    public void passarPeloBuracoSemCairNeleNaoCausaDano() {
        Peach peach = new Peach();
        Casa[] casasCustomizadas = {new CasaBuraco(2)};
        RainbowRoad rainbowRoad = new RainbowRoad(casasCustomizadas);

        rainbowRoad.adicionarCorredor(peach);

        assertEquals(6, peach.getVida());

        peach.andar();

        assertEquals(6, peach.getVida());

        assertEquals(3, rainbowRoad.getCasaOndeCorredorEsta(peach).getNumeroDaCasa());

    }

    @Test
    public void corredorQueCaiNaCasaAndaUmaVezAdicional() {
        CasaTurbo casaTurbo = new CasaTurbo(3);
        Casa[] casasCustomizaveis = {casaTurbo};

        RainbowRoad rainbowRoad = new RainbowRoad(casasCustomizaveis);
        Luigi luigi = new Luigi();

        rainbowRoad.adicionarCorredor(luigi);

        luigi.andar();

        Casa casaEsperada = rainbowRoad.getCasaOndeCorredorEsta(luigi);

        assertEquals(6, casaEsperada.getNumeroDaCasa());

    }

    @Test
    public void cairNaCasaGanhaItem() {
        CascoVerde cascoVerde = new CascoVerde();
        CasaItem casaItem = new CasaItem(1, cascoVerde);

        Peach peach = new Peach();

        casaItem.adicionarCorredor(peach);

        assertEquals(cascoVerde, peach.getItemArmazenado());
    }
}
