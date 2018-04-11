import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagoArcanoTest {
    @Test
    void testaMagoQueSobeDeNivel(){
        MagoArcano magoArcano=new MagoArcano();
        int vidaEsperada=20;
        magoArcano.sobeNivel();
        int vidaObtida=magoArcano.getVida();

        assertEquals(vidaEsperada,vidaObtida);
    }
}