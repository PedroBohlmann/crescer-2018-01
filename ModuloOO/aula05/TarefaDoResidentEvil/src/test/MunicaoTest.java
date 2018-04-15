package test;

import inventario.Inventario;
import itens.armamento.Arma;
import itens.armamento.Municao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MunicaoTest {
    @Test
    public void testaQuantidadeDeBalas() {
        Arma arma = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Municao municao = new Municao(1, 1, 22, "MunicaoTresOitao", 20);
        arma.recarrega(municao);
        int balasNaMunicaoEsperado = 12;

        int balasNaMunicaoObtido = municao.getBalas();

        assertEquals(balasNaMunicaoEsperado, balasNaMunicaoObtido);
    }

    @Test
    public void testaQuantidadeDeBalasTentandoUtilizarMaisBalasQueTemNaMunicao() {
        Inventario inventario=new Inventario(10,10);
        Arma arma = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Municao municao = new Municao(1, 1, 22, "MunicaoTresOitao", 6);
        inventario.adicionarItem(arma);
        inventario.adicionarItem(municao);

        arma.recarrega(municao);
        int balasNaMunicaoEsperado = 0;

        int balasNaMunicaoObtido = municao.getBalas();

        assertEquals(balasNaMunicaoEsperado, balasNaMunicaoObtido);

    }
}
