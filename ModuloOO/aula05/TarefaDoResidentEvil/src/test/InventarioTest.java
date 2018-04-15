package test;

import inventario.Inventario;
import itens.armamento.Arma;
import itens.Item;
import itens.armamento.Municao;
import itens.ervas.Erva;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventarioTest {

    @Test
    public void testaEspacoDisponivelEmInventarioVazio() {
        Inventario inventario = new Inventario(5, 5);
        int espacosVaziosEsperados = 25;
        int espacosVaziosObtidos = inventario.verificaEspacoDiponiveis();

        assertEquals(espacosVaziosEsperados, espacosVaziosObtidos);
    }

    @Test
    public void testaSeTresOitaoCabe() {
        Inventario inventario = new Inventario(5, 5);
        Arma arma = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        boolean resultadoEsperado = true;

        boolean resultadoObtido = inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaSeCalibreDoseCabe() {
        Inventario inventario = new Inventario(5, 5);
        Arma arma = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");
        boolean resultadoEsperado = false;

        boolean resultadoObtido = inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaSeCalibreDoseViradaCabeEmInventarioDoMesmoTamanho() {
        Inventario inventario = new Inventario(7, 3);
        Arma arma = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");
        boolean resultadoEsperado = true;

        boolean resultadoObtido = inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaSeCalibreDoseCabeEmInventarioDoMenorTamanho() {
        Inventario inventario = new Inventario(3, 3);
        Arma arma = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");
        boolean resultadoEsperado = false;

        boolean resultadoObtido = inventario.verificaSeItemCabe(arma);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testaAdicionandoTresOitaoNaMatriz() {
        Inventario inventario = new Inventario(5, 5);
        Arma arma = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");

        inventario.adicionarItem(arma);

        Item obtido = inventario.pegaItemNaPosicao(2, 1);

        assertEquals(arma, obtido);
    }

    @Test
    public void testaAdicionandoTresOitaoECalibre12NaMatrizEVerificaSeACalibre12FoiParaOndePrecisariaIr() {
        Inventario inventario = new Inventario(10, 10);
        Arma tresOitao = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Arma calibre12 = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");

        inventario.adicionarItem(tresOitao);
        inventario.adicionarItem(calibre12);

        Item esperado = calibre12;
        Item obtido = inventario.pegaItemNaPosicao(2, 8);

        assertEquals(esperado, obtido);
    }

    @Test
    public void testaRemovendoTresOitaoNaMatriz() {
        Inventario inventario = new Inventario(5, 5);
        Arma arma = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        inventario.adicionarItem(arma);

        inventario.removerItem(arma);
        Item esperado = null;
        Item obtido = inventario.pegaItemNaPosicao(2, 1);

        assertEquals(esperado, obtido);
    }

    @Test
    public void testaRemovendoTresOitaoEDeixandoCalibre12NaMatriz() {
        Inventario inventario = new Inventario(10, 10);
        Arma tresOitao = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Arma calibre12 = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");

        inventario.adicionarItem(tresOitao);
        inventario.adicionarItem(calibre12);

        inventario.removerItem(tresOitao);

        Item esperado = calibre12;
        Item obtido = inventario.pegaItemNaPosicao(0, 2);

        assertEquals(esperado, obtido);
    }

    @Test
    public void testaQualItemMaiorItem() {
        Inventario inventario = new Inventario(10, 10);
        Arma tresOitao = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Arma calibre12 = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");

        inventario.adicionarItem(tresOitao);
        inventario.adicionarItem(calibre12);

        Item esperado = calibre12;
        Item obtido = inventario.maiorItem();

        assertEquals(esperado, obtido);
    }

    @Test
    public void testaPesoTotalDoInventario() {
        Inventario inventario = new Inventario(10, 10);
        Arma tresOitao = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Arma calibre12 = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");

        inventario.adicionarItem(tresOitao);
        inventario.adicionarItem(calibre12);

        int pesoEsperado = 4;
        int pesoObtido = inventario.pesoTotal();

        assertEquals(pesoEsperado, pesoObtido);
    }

    @Test
    public void testaMunicaoSaindoDoInventario() {
        Inventario inventario = new Inventario(10, 10);
        Arma tresOitao = new Arma(3, 2, 2, "TresOitao", 8, 1, "MunicaoTresOitao");
        Municao municao = new Municao(1, 1, 22, "MunicaoTresOitao", 6);
        inventario.adicionarItem(tresOitao);
        inventario.adicionarItem(municao);

        tresOitao.recarrega(municao);

        Item esperado = null;
        Item obtido = inventario.pegaItemNaPosicao(0, 2);

        assertEquals(esperado, obtido);

    }

    @Test
    public void testaErvaSendoMisturadaETiradaDoInventario() {
        Inventario inventario = new Inventario(5, 5);
        Erva ervaVerde = new Erva(1, 1, 1, "Erva Verde");
        Erva ervaVermelha = new Erva(1, 1, 1, "Erva Vermelha");

        inventario.adicionarItem(ervaVerde);
        inventario.adicionarItem(ervaVermelha);

        ervaVerde.misturarCom(ervaVermelha);
        Item resultadoEsperado = null;
        Item resultadoObtido = inventario.pegaItemNaPosicao(0, 1);

        assertEquals(resultadoEsperado, resultadoObtido);

    }

    @Test
    public void testaColocandoArmaVirada() {
        Inventario inventario = new Inventario(7, 3);
        Arma calibre12 = new Arma(3, 7, 2, "Calibre12", 2, 2, "MunicaoCalibre12");

        inventario.adicionarItem(calibre12);

        Item esperado = calibre12;
        Item obtido = inventario.pegaItemNaPosicao(6, 2);

        assertEquals(esperado, obtido);
    }
}
