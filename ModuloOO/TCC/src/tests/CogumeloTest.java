package tests;

import corredores.Luigi;
import exceptions.ItemInvalidoException;
import itens.Cogumelo;
import org.junit.jupiter.api.Test;
import pistas.Casa;
import pistas.DonutPlains;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CogumeloTest {

    @Test
    public void corredorAnda4CasasQuandoUsaCogumelo() throws ItemInvalidoException {
        Luigi luigi = new Luigi();
        DonutPlains donutPlains = new DonutPlains();
        donutPlains.adicionarCorredor(luigi);

        Cogumelo cogumelo = new Cogumelo();

        luigi.andar();

        Casa casaObtido = donutPlains.getCasaOndeCorredorEsta(luigi);
        assertEquals(3, casaObtido.getNumeroDaCasa());

        luigi.equiparItem(cogumelo);

        luigi.usarItem(cogumelo);

        casaObtido = donutPlains.getCasaOndeCorredorEsta(luigi);

        assertEquals(7, casaObtido.getNumeroDaCasa());

    }
}
