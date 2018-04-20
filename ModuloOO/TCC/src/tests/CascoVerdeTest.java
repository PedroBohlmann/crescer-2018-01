package tests;

import corredores.Bowser;
import corredores.Luigi;
import exceptions.AlvoInvalidoException;
import exceptions.ItemInvalidoException;
import itens.CascoVerde;
import org.junit.jupiter.api.Test;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CascoVerdeTest {

    @Test
    public void lancaCascoVerdeTira3DeVida() throws AlvoInvalidoException, ItemInvalidoException {
        Luigi luigi = new Luigi();
        Bowser bowser = new Bowser();

        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);
        donutPlains.adicionarCorredor(bowser);

        CascoVerde cascoVerde = new CascoVerde();

        luigi.equiparItem(cascoVerde);

        assertEquals(10, bowser.getVida());

        luigi.usarItem(cascoVerde, bowser);

        assertEquals(7, bowser.getVida());

    }

    @Test
    public void naoPodeLancarCascoVerdeEmSiMesmo() {
        Luigi luigi = new Luigi();
        CascoVerde cascoVerde = new CascoVerde();

        luigi.equiparItem(cascoVerde);

        assertThrows(AlvoInvalidoException.class, () -> {
            luigi.usarItem(cascoVerde, luigi);
        });
    }
}
