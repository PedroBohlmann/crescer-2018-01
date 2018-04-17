package tests;

import dia.Dia;
import org.junit.jupiter.api.Test;
import produtos.Manutencao;
import produtos.Produto;
import produtos.Veiculo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaTest {

    @Test
    public void testaInserindoListaNoDia(){
        Produto veiculo=new Veiculo(10000,10,1,"Fiat","Uno","Azul");
        Manutencao manutencaoCara=new Manutencao(100,10,2,2);
        Manutencao manutencaoBarata=new Manutencao(1,10,2,2);

        List<Produto>  listaASerInserida=new ArrayList<>();

        listaASerInserida.add(veiculo);
        listaASerInserida.add(manutencaoCara);
        listaASerInserida.add(manutencaoBarata);

        Dia dia=new Dia();

        dia.vendeProdutosEmLote(listaASerInserida);

        Produto esperado=veiculo;
        Produto obtido = dia.getProdutoNaPosicao(0);

        assertEquals(esperado,obtido);

    }

    @Test
    public void testaDiaInserindoProdutosEOrdenandoCrescente(){
        Produto veiculo=new Veiculo(10000,10,1,"Fiat","Uno","Azul");
        Manutencao manutencaoCara=new Manutencao(100,10,2,2);
        Manutencao manutencaoBarata=new Manutencao(1,10,2,2);

        Dia dia=new Dia();
        dia.vendeProduto(veiculo);
        dia.vendeProduto(manutencaoCara);
        dia.vendeProduto(manutencaoBarata);

        dia.ordernarProdutosDeFormaCrescente();

        Produto esperadoo=manutencaoBarata;
        Produto obtido=dia.getProdutoNaPosicao(0);

        assertEquals(esperadoo,obtido);
    }

    @Test
    public void testaDiaInserindoProdutosEOrdenandoDeCrescente(){
        Produto veiculo=new Veiculo(10000,10,1,"Fiat","Uno","Azul");
        Manutencao manutencaoCara=new Manutencao(100,10,2,2);
        Manutencao manutencaoBarata=new Manutencao(1,10,2,2);

        Dia dia=new Dia();
        dia.vendeProduto(veiculo);
        dia.vendeProduto(manutencaoCara);
        dia.vendeProduto(manutencaoBarata);

        dia.ordernarProdutosDeFormaDeCrescente();

        Produto esperado=veiculo;
        Produto obtido=dia.getProdutoNaPosicao(0);

        assertEquals(esperado,obtido);
    }


    @Test
    public void testaCalculoDeEntradaTotal(){
        Produto veiculoUno = new Veiculo(10000, 50, 1.0, "Fiat", "Uno", "branco");//18645
        Produto veiculoJetta = new Veiculo(10000, 40, 2.0, "VW", "Jetta", "branco");//18242
        //TODO:colocar Servicos
        Dia dia=new Dia();

        dia.vendeProduto(veiculoJetta);
        dia.vendeProduto(veiculoUno);

        double valorEsperado = 36887;
        double valorObtido=dia.calcularValorTotalDeEntrada();

        assertEquals(valorEsperado,valorObtido);
    }

    @Test
    public void testaCalculoDeLucroTotal(){
        Produto veiculo = new Veiculo(10000, 10, 2.0, "VW", "Jetta", "branco");//1303
        //TODO:colocar mais veiculos
        Dia dia=new Dia();

        dia.vendeProduto(veiculo);

        double lucroEsperado=1303;
        double lucroObtido=dia.calcularValorTotalDeLucro();

        assertEquals(lucroEsperado,lucroObtido);
    }
}
