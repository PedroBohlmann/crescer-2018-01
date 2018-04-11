import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcademiaArcanaTest {
    @Test
    void testaAcademiaArcanaQueTreinaUmMagoQueTreinaTresVezes(){
        MagoArcano magoArcano=new MagoArcano();
        AcademiaArcana academiaArcana=new AcademiaArcana();
        int poderMagicoEsperado=21;

        academiaArcana.treinaMago(magoArcano);

        academiaArcana.treinaMago(magoArcano);
        academiaArcana.treinaMago(magoArcano);
        int poderMagicoObtido= magoArcano.getPoderMagico();

        assertEquals(poderMagicoEsperado,poderMagicoObtido);
    }

    @Test
    void testaAcademiaArcanaQueTreinaUmMagoQueTreinaUmaVez(){
        MagoArcano magoArcano=new MagoArcano();
        AcademiaArcana academiaArcana=new AcademiaArcana();
        int poderMagicoEsperado=4;
        academiaArcana.treinaMago(magoArcano);

        int poderMagicoObtido= magoArcano.getPoderMagico();

        assertEquals(poderMagicoEsperado,poderMagicoObtido);
    }
}
