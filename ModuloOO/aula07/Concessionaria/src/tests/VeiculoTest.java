package tests;

import org.junit.jupiter.api.Test;
import produtos.Produto;
import produtos.Veiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeiculoTest {
    @Test
    public void testarCalcularValorTotalImpostosRetornandoZero(){
        //Arrange
        Produto veiculo = new Veiculo(0, 50, 1.0, "VW", "Gol", "branco");
        double valorTotalImpostosEsperado = 0.0;
        //Act
        double valorTotalImpostosRetornado = veiculo.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void testarCalcularValorTotalImpostosVeiculoBaixaPotencia(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 1.0, "VW", "Gol", "branco");
        double valorTotalImpostosEsperado = 2430.0;
        //Act
        double valorTotalImpostosRetornado = veiculo.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void testarCalcularValorTotalImpostosVeiculoAltaPotencia(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 2.0, "VW", "Jetta", "branco");
        double valorTotalImpostosEsperado = 3030;
        //Act
        double valorTotalImpostosRetornado = veiculo.calcularValorTotalImpostos();
        //Assert
        assertEquals(valorTotalImpostosEsperado, valorTotalImpostosRetornado);
    }
    @Test
    public void calcularLucroTotalDeveRetornarZero(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 0, 2.0, "VW", "Jetta", "branco");
        double lucroTotalEsperado = 0.0;
        //Act
        double lucroTotalRetornado = veiculo.calcularLucroTotal();
        //Assert
        assertEquals(lucroTotalEsperado, lucroTotalRetornado);
    }
    @Test
    public void calcularLucroTotalDeveRetornarValorVeiculo(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 10, 2.0, "VW", "Jetta", "branco");
        double lucroTotalEsperado = 1303;
        //Act
        double lucroTotalRetornado = veiculo.calcularLucroTotal();
        //Assert
        assertEquals(lucroTotalEsperado, lucroTotalRetornado);
    }

    @Test
    public void calcularValorTotalVeiculoDeveRetornarZero(){
        //Arrange
        Produto veiculo = new Veiculo(0, 10, 2.0, "VW", "Jetta", "branco");
        double valorTotalEsperado = 0;
        //Act
        double valorTotalRetornado = veiculo.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void calcularValorTotalVeiculoBaixaPotenciaDeveRetornarValor(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 1.0, "Fiat", "Uno", "branco");
        double valorTotalEsperado = 18645;
        //Act
        double valorTotalRetornado = veiculo.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void calcularValorTotalVeiculoAltaPotenciaDeveRetornarValor(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 40, 2.0, "VW", "Jetta", "branco");
        double valorTotalEsperado = 18242;
        //Act
        double valorTotalRetornado = veiculo.calcularValorTotal();
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
}
