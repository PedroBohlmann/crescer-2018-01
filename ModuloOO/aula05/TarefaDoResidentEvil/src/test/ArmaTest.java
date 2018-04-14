package test;

import itens.Arma;
import itens.Municao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaTest {
    @Test
    public void testaArmaSendoRecarregada(){
        Arma arma=new Arma(2,2,2,"TresOitao",8,1);
        Municao municao=new Municao(1,1,22,"Municao38",8);
        int balasNaArmaEsperada=8;

        arma.recarrega(municao);
        int balasNaArmaObtida= arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperada,balasNaArmaObtida);
    }

    @Test
    public void testaArmaSendoRecarregadaComMenosBalasQueCapacidadeTotal(){
        Arma arma=new Arma(2,2,2,"TresOitao",8,1);
        Municao municao=new Municao(1,1,22,"Municao38",4);
        int balasNaArmaEsperada=4;

        arma.recarrega(municao);
        int balasNaArmaObtida= arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperada,balasNaArmaObtida);
    }
    //realizar testes com disparos
    //realizar testes
}
