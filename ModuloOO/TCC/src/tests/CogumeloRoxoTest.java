package tests;

import corredores.Luigi;
import exceptions.ItemInvalidoException;
import itens.CogumeloRoxo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CogumeloRoxoTest {

    @Test
    public void adicionaPontosDeVidaAoCorredor() throws ItemInvalidoException {
        Luigi luigi=new Luigi();
        CogumeloRoxo cogumeloRoxo=new CogumeloRoxo();

        luigi.equiparItem(cogumeloRoxo);

        assertEquals(5,luigi.getVida());

        luigi.usarItem(cogumeloRoxo);

        assertEquals(7,luigi.getVida());
    }
}
