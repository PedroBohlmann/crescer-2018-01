package tests;

import corredores.Luigi;
import corredores.Mario;
import exceptions.AlvoInvalidoException;
import exceptions.ItemInvalidoException;
import itens.CascoVerde;
import itens.Cogumelo;
import org.junit.jupiter.api.Test;
import pistas.casas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CorredorTest {

    @Test
    public void corredorQuePerdeTodaVidaSaiDaCorrida() throws AlvoInvalidoException, ItemInvalidoException {
        Mario mario = new Mario();
        Luigi luigi = new Luigi();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(mario);
        donutPlains.adicionarCorredor(luigi);

        CascoVerde cascoVerde = new CascoVerde();

        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde, luigi);


        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde, luigi);

        Casa casaObtido = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(null, casaObtido);
    }

    @Test
    public void corredorTentaUsarItemDiferenteDeItemEquipado() {
        Luigi luigi = new Luigi();
        CascoVerde cascoVerde = new CascoVerde();
        Cogumelo cogumelo = new Cogumelo();

        luigi.equiparItem(cascoVerde);

        assertThrows(ItemInvalidoException.class, () -> {
            luigi.usarItem(cogumelo);
        });
    }
}
