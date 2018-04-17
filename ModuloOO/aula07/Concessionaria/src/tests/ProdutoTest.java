package tests;

import org.junit.jupiter.api.Test;
import produtos.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {
    @Test
    public void testarCalcularValorTotalImpostosRetornandoZero(){
        //Arrange
        Produto produto = new Produto(0, 0);
        double valorTotalImpostosEsperado = 0.0;
        //Act
        double valorTotalImpostosRetornado = produto.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void calcularValorTotalImpostosDeveRetornar13(){
        //Arrange
        Produto produto = new Produto(100, 0);
        double valorTotalImpostosEsperado = 13.0;
        //Act
        double valorTotalImpostosRetornado = produto.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void calcularLucroTotalDeveRetornarZero(){
        //Arrange
        Produto produto = new Produto(1000, 0);
        double lucroTotalEsperado = 0.0;
        //Act
        double lucroTotalRetornado = produto.calcularLucroTotal();
        //Assert
        assertEquals(lucroTotalEsperado, lucroTotalRetornado);
    }
    @Test
    public void calcularLucroTotalDeveRetornarValor(){
        //Arrange
        Produto produto = new Produto(100, 10);
        double lucroTotalEsperado = 11.3;
        //Act
        double lucroTotalRetornado = produto.calcularLucroTotal();
        //Assert
        assertEquals(lucroTotalEsperado, lucroTotalRetornado);
    }
    @Test
    public void calcularValorTotalProdutoDeveRetornarZero(){
        //Arrange
        Produto produto = new Produto(0, 100);
        double valorTotalEsperado = 0;
        //Act
        double valorTotalRetornado = produto.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void calcularValorTotalProdutoDeveRetornarValor(){
        //Arrange
        Produto produto = new Produto(1000, 100);
        double valorTotalEsperado = 2260;
        //Act
        double valorTotalRetornado = produto.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
}
