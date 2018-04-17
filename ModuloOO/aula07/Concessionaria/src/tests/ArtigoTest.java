package tests;

import org.junit.jupiter.api.Test;
import produtos.Artigo;
import produtos.Produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtigoTest {
    @Test
    public void testarCalcularValorTotalImpostosRetornandoZero(){
        //Arrange
        Produto peca = new Artigo(0, 0, "Turbo", "peça para carro");
        double valorTotalImpostosEsperado = 0.0;
        //Act
        double valorTotalImpostosRetornado = peca.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void calcularValorTotalImpostosDeveRetornar13(){
        //Arrange
        Produto peca = new Artigo(100, 0, "Turbo", "peça para carro");
        double valorTotalImpostosEsperado = 13.0;
        //Act
        double valorTotalImpostosRetornado = peca.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void calcularLucroTotalDeveRetornarZero(){
        //Arrange
        Produto peca = new Artigo(0, 0, "Turbo", "peça para carro");
        double lucroTotalEsperado = 0.0;
        //Act
        double lucroTotalRetornado = peca.calcularLucroTotal();
        //Assert
        assertEquals(lucroTotalEsperado, lucroTotalRetornado);
    }
    @Test
    public void calcularLucroTotalDeveRetornarValor(){
        //Arrange
        Produto peca = new Artigo(100, 10, "Turbo", "peça para carro");
        double lucroTotalEsperado = 11.3;
        //Act
        double lucroTotalRetornado = peca.calcularLucroTotal();
        //Assert
        assertEquals(lucroTotalEsperado, lucroTotalRetornado);
    }
    @Test
    public void calcularValorTotalProdutoDeveRetornarZero(){
        //Arrange
        Produto peca = new Artigo(0, 0, "Turbo", "peça para carro");
        double valorTotalEsperado = 0;
        //Act
        double valorTotalRetornado = peca.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void calcularValorTotalProdutoDeveRetornarValor(){
        //Arrange
        Produto peca = new Artigo(1000, 100, "Turbo", "peça para carro");
        double valorTotalEsperado = 2260;
        //Act
        double valorTotalRetornado = peca.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
}
