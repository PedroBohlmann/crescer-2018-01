package tests;

import corredores.Luigi;
import corredores.Mario;
import exceptions.AlvoInvalidoException;
import exceptions.ItemInvalidoException;
import itens.CascoVerde;
import itens.CogumeloRoxo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CogumeloRoxoTest {

    @Test
    public void adicionaPontosDeVidaAoCorredor() throws ItemInvalidoException {
        Luigi luigi = new Luigi();
        CogumeloRoxo cogumeloRoxo = new CogumeloRoxo();

        luigi.equiparItem(cogumeloRoxo);

        assertEquals(5, luigi.getVida());

        luigi.usarItem(cogumeloRoxo);

        assertEquals(7, luigi.getVida());
    }

    @Test
    public void adicionarPontosDeVidaAoCorredorQueLevaDano() throws AlvoInvalidoException, ItemInvalidoException {
        Mario mario = new Mario();
        Luigi luigi = new Luigi();

        CascoVerde cascoVerde = new CascoVerde();
        CogumeloRoxo cogumeloRoxo = new CogumeloRoxo();

        assertEquals(5, luigi.getVida());

        mario.equiparItem(cascoVerde);
        mario.usarItem(cascoVerde, luigi);

        assertEquals(2, luigi.getVida());

        luigi.equiparItem(cogumeloRoxo);
        luigi.usarItem(cogumeloRoxo);

        assertEquals(4, luigi.getVida());

    }
}
