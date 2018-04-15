package test;

import inventario.Inventario;
import itens.ervas.Erva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErvaTest {
    @Test
    public void testaMisturaErvaVerdeComErvaVermelho() {
        Inventario inventario = new Inventario(5, 5);
        Erva ervaVerde = new Erva(1, 1, 1, "Erva Verde");
        Erva ervaVermelha = new Erva(1, 1, 1, "Erva Vermelha");

        inventario.adicionarItem(ervaVerde);
        inventario.adicionarItem(ervaVermelha);

        ervaVerde.misturarCom(ervaVermelha);

        String misturaEsperada = "Mistura de Erva Verde com Erva Vermelha";
        String misturaObtida = ervaVerde.getMistura();

        assertEquals(misturaEsperada, misturaObtida);
    }

    @Test
    public void testaErvaSemMistura() {
        Erva ervaVerde = new Erva(1, 1, 1, "Erva Verde");

        String misturaEsperada = "Erva Verde";
        String misturaObtida = ervaVerde.getMistura();

        assertEquals(misturaEsperada, misturaObtida);
    }

    @Test
    public void testaErvaTentandoSerMisturadaComSiMesma() {
        Erva ervaVerde = new Erva(1, 1, 1, "Erva Verde");

        ervaVerde.misturarCom(ervaVerde);

        String misturaEsperada = "Erva Verde";
        String misturaObtida = ervaVerde.getMistura();

        assertEquals(misturaEsperada, misturaObtida);
    }


}
