package test;

import itens.Arma;
import itens.Municao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MunicaoTest {
    @Test
    public void testaQuantidadeDeBalas(){
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",20);
        arma.recarrega(municao);
        int balasNaMunicaoEsperado=12;

        int balasNaMunicaoObtido=municao.getBalas();

        assertEquals(balasNaMunicaoEsperado,balasNaMunicaoObtido);
    }

    @Test
    public void testaQuantidadeDeBalasTentandoUtilizarMaisBalasQueTemNaMunicao(){
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        Municao municao=new Municao(1,1,22,"MunicaoTresOitao",6);
        arma.recarrega(municao);
        int balasNaMunicaoEsperado=0;

        int balasNaMunicaoObtido=municao.getBalas();

        assertEquals(balasNaMunicaoEsperado,balasNaMunicaoObtido);

    }
}
