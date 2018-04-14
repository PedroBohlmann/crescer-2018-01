package test;

import inventario.Inventario;
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
}
