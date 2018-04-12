import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcademiaDoFogoTest {
    @Test
    void testaTreinoDeMagoNivel1QueTentaUsarMaisManaQuePodeNaAcademiaNivel10(){
        MagoArcano magoArcano=new MagoArcano();
        AcademiaDoFogo academiaDoFogo=new AcademiaDoFogo(10);
        academiaDoFogo.treinarMago(magoArcano);
        int poderEsperado=16;
        int poderObtido= magoArcano.soltaBolaDeFogo(6);

        assertEquals(poderEsperado,poderObtido);
    }
    @Test
    void testaTreinoDeMagoNivel2QueTentaUsarMenosManaQueTemNaAcademiaNivel3(){
        MagoArcano magoArcano=new MagoArcano();
        AcademiaDoFogo academiaDoFogo=new AcademiaDoFogo(10);
        academiaDoFogo.treinarMago(magoArcano);
        magoArcano.sobeNivel();
        int poderEsperado=18;
        int poderObtido= magoArcano.soltaBolaDeFogo(4);

        assertEquals(poderEsperado,poderObtido);
    }

    @Test
    void testaGastoDeTodaManaDuranteBolaDeFogo(){
        MagoArcano magoArcano=new MagoArcano();
        AcademiaDoFogo academiaDoFogo=new AcademiaDoFogo(1);
        academiaDoFogo.treinarMago(magoArcano);
        int manaEsperado=0;
        magoArcano.soltaBolaDeFogo(5);
        int manaObtido = magoArcano.getMana();

        assertEquals(manaEsperado,manaObtido);
    }

    @Test
    void testaMagoQueNaoSabeUsarBolaDeFogo(){
        MagoArcano magoArcano=new MagoArcano();

        int resultadoEsperado=0;
        int resultadoObtido= magoArcano.soltaBolaDeFogo(3);

        assertEquals(resultadoEsperado,resultadoObtido);
    }
}
