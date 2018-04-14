package test;

import itens.Arma;
import itens.Municao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmaTest {

    @Test
    public void testaTresOitaoSendoRecarregada(){
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",20);
        int balasNaArmaEsperada=8;

        arma.recarrega(municao);
        int balasNaArmaObtida= arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperada,balasNaArmaObtida);
    }

    @Test
    public void testaTresSendoRecarregadaComMenosBalasQueCapacidadeTotal(){
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",4);
        int balasNaArmaEsperada=4;

        arma.recarrega(municao);
        int balasNaArmaObtida= arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperada,balasNaArmaObtida);
    }

    @Test
    public void testaTresOitaoDisparandoUmaVez(){
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",20);
        arma.recarrega(municao);
        int balasNaArmaEsperado=7;

        arma.dispara();

        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }

    @Test
    public void testaTresOitaoTentandoDispararNoveVezes(){
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",20);
        arma.recarrega(municao);
        int balasNaArmaEsperado=0;

        for(int i =0;i<9;i++) {
            arma.dispara();
        }

        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }

    @Test
    public void testaCalibre12SendoRecarrega(){
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        Municao municao=new Municao(1,1,22,"MunicaoCalibre12",8);
        arma.recarrega(municao);
        int balasNaArmaEsperado=2;

        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }

    @Test
    public void testaCalibre12SendoDisparandoUmaVez(){
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        Municao municao=new Municao(1,1,22,"MunicaoCalibre12",8);
        arma.recarrega(municao);
        int balasNaArmaEsperado=0;

        arma.dispara();
        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }

    @Test
    public void testaCalibre12TentandoDisparandoDuasVezes(){
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        Municao municao=new Municao(1,1,22,"MunicaoCalibre12",8);
        arma.recarrega(municao);
        int balasNaArmaEsperado=0;

        arma.dispara();
        arma.dispara();
        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }

    @Test
    public void testaRecarregarTresOitaoComMunicaoCalibre12(){
        Arma arma=new Arma(3,7,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoCalibre12",8);
        arma.recarrega(municao);
        int balasNaArmaEsperado=0;

        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }

    @Test
    public void testaRecarregarCalibre12ComMunicaoCalibre12(){
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",20);
        arma.recarrega(municao);
        int balasNaArmaEsperado=0;

        int balasNaArmaObtido=arma.getBalasNaArma();

        assertEquals(balasNaArmaEsperado,balasNaArmaObtido);

    }



}
