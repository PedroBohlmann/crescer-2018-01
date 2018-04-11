import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagoTest {
    @Test
    void testaMagoDeveIniciarComNivel1Tem10DeVida(){
        Mago mago = new Mago();
        int vidaEsperada =10;
        int vidaObtida =mago.getVida();

        assertEquals(vidaEsperada,vidaObtida);
    }

    @Test
    void testaMagoDeveTerNivel2Tem14DeVida(){
        Mago mago = new Mago();
        mago.passarDeNivel();
        int vidaEsperada =14;
        int vidaObtida =mago.getVida();

        assertEquals(vidaEsperada,vidaObtida);
    }

    @Test
    void testaMagoDeveIniciarComVidaMudadaPara5(){
        Mago mago = new Mago();
        mago.setVida(5);
        int vidaEsperada =5;
        int vidaObtida =mago.getVida();

        assertEquals(vidaEsperada,vidaObtida);
    }
}