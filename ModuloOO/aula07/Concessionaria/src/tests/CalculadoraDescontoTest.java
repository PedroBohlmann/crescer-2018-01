package tests;

import org.junit.jupiter.api.Test;
import produtos.Artigo;
import produtos.Produto;
import produtos.Veiculo;
import utilitario.CalculadoraDesconto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraDescontoTest {
    @Test
    public void testarCalcularDescontoProduto(){
        //Arrange
        Produto produto = new Produto(1000, 100);
        double valorTotalEsperado = 2034;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calcularValorTotalProdutoComDesconto(produto, 10);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoProdutoComZeroDePercentual(){
        //Arrange
        Produto produto = new Produto(1000, 100);
        double valorTotalEsperado = 2260;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calcularValorTotalProdutoComDesconto(produto, 0);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoArtigoComZeroDePercentual(){
        //Arrange
        Produto artigo = new Artigo(1000, 100, "Suspensão", "Peça de veículo");
        double valorTotalEsperado = 2260;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calcularValorTotalProdutoComDesconto(artigo, 0);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoArtigoComDescontoAplicado(){
        //Arrange
        Produto artigo = new Artigo(1000, 100, "Suspensão", "Peça de veículo");
        double valorTotalEsperado = 2034;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calcularValorTotalProdutoComDesconto(artigo, 10);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoVeiculoSemDescontoAplicado(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 1,"Fiat", "Uno", "Branco");
        double valorTotalEsperado = 18645;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calcularValorTotalProdutoComDesconto(veiculo, 0);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoVeiculoComDescontoAplicado(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 1,"Fiat", "Uno", "Branco");
        double valorTotalEsperado = 16780.5;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calcularValorTotalProdutoComDesconto(veiculo, 10);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
}
