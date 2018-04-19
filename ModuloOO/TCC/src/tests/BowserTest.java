package tests;

import corredores.Bowser;
import org.junit.jupiter.api.Test;
import pistas.casas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowserTest {

    @Test
    public void anda2CasasAMaisDepoisDaSegundaVez(){
        DonutPlains donutPlains=new DonutPlains();
        Bowser bowser=new Bowser();
        Casa casaEsperado=null;

        donutPlains.adicionarCorredor(bowser);

        bowser.andar();
        casaEsperado = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(1,casaEsperado.getNumeroDaCasa());


        bowser.andar();
        casaEsperado = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(2,casaEsperado.getNumeroDaCasa());

        bowser.andar();
        casaEsperado = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(7,casaEsperado.getNumeroDaCasa());

        bowser.andar();
        casaEsperado = donutPlains.getCasaOndeCorredorEsta(bowser);
        assertEquals(12,casaEsperado.getNumeroDaCasa());

    }
}
