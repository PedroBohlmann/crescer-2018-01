package tests;

import corredores.Peach;
import org.junit.jupiter.api.Test;
import pistas.casas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeachTest {

    @Test
    public void peachGanharBonusDe2CasasQuandoAndaPelaTerceiraVez(){
        DonutPlains donutPlains=new DonutPlains();
        Peach peach=new Peach();

        donutPlains.adicionarCorredor(peach);

        Casa casaOndeEsta=null;

        peach.andar();
        casaOndeEsta=donutPlains.getCasaOndeCorredorEsta(peach);
        assertEquals(3,casaOndeEsta.getNumeroDaCasa());


        peach.andar();
        casaOndeEsta=donutPlains.getCasaOndeCorredorEsta(peach);
        assertEquals(6,casaOndeEsta.getNumeroDaCasa());


        peach.andar();
        casaOndeEsta=donutPlains.getCasaOndeCorredorEsta(peach);
        assertEquals(11,casaOndeEsta.getNumeroDaCasa());
    }
}
