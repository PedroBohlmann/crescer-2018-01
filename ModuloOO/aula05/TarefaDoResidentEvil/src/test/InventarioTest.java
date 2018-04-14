package test;

import inventario.Inventario;
import itens.Arma;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventarioTest {
    @Test
    public void testaEspacoDisponivelEmInventarioVazio(){
        Inventario inventario=new Inventario(5,5);
        int espacosVaziosEsperados=25;
        int espacosVaziosObtidos= inventario.verificaEspacoDiponiveis();

        assertEquals(espacosVaziosEsperados,espacosVaziosObtidos);
    }

    @Test
    public void testaSeTresOitaoCabe(){
        Inventario inventario=new Inventario(5,5);
        Arma arma=new Arma(3,2,2,"TresOitao",8,1,"MunicaoTresOitao");
        boolean resultadoEsperado=true;

        boolean resultadoObtido=inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testaSeCalibreDoseCabe(){
        Inventario inventario=new Inventario(5,5);
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        boolean resultadoEsperado=false;

        boolean resultadoObtido=inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testaSeCalibreDoseViradaCabeEmInventarioDoMesmoTamanho(){
        Inventario inventario=new Inventario(7,3);
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        boolean resultadoEsperado=true;

        boolean resultadoObtido=inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado,resultadoObtido);
    }

    @Test
    public void testaSeCalibreDoseCabeEmInventarioDoMenorTamanho(){
        Inventario inventario=new Inventario(3,3);
        Arma arma=new Arma(3,7,2,"Calibre12",2,2,"MunicaoCalibre12");
        boolean resultadoEsperado=false;

        boolean resultadoObtido=inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado,resultadoObtido);
    }
}
