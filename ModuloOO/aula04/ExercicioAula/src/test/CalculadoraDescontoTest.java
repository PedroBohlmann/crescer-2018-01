package test;

import calculadora.CalculadoraDesconto;
import org.junit.jupiter.api.Test;
import produtos.Artigo;
import produtos.Produto;
import produtos.Veiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraDescontoTest {
    @Test
    void testaDescontoEmVeiculo(){
        Veiculo carro=new Veiculo(10000,10,0.2,"Fiat","Uno","Azul");
        double valorEsperado=12305.7;
        double valorObtido= CalculadoraDesconto.calculaDesconto(carro,10);

        assertEquals(valorEsperado,valorObtido);
    }

    @Test
    void testaDescontoEmArtigo(){
        Artigo artigo=new Artigo(200,10,"Nitro","Super Fast");
        double valorEsperado=229.7064;
        double valorObtido=CalculadoraDesconto.calculaDesconto(artigo,7.6);

        assertEquals(valorEsperado,valorObtido);
    }
    @Test
    public void testarCalcularDescontoProduto(){
        //Arrange
        Produto produto = new Produto(1000, 100);
        double valorTotalEsperado = 2034;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calculaDesconto(produto, 10);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoProdutoComZeroDePercentual(){
        //Arrange
        Produto produto = new Produto(1000, 100);
        double valorTotalEsperado = 2260;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calculaDesconto(produto, 0);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoArtigoComZeroDePercentual(){
        //Arrange
        Produto artigo = new Artigo(1000, 100, "Suspensão", "Peça de veículo");
        double valorTotalEsperado = 2260;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calculaDesconto(artigo, 0);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoArtigoComDescontoAplicado(){
        //Arrange
        Produto artigo = new Artigo(1000, 100, "Suspensão", "Peça de veículo");
        double valorTotalEsperado = 2034;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calculaDesconto(artigo, 10);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoVeiculoSemDescontoAplicado(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 1,"Fiat", "Uno", "Branco");
        double valorTotalEsperado = 18645;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calculaDesconto(veiculo, 0);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
    @Test
    public void testarCalcularDescontoVeiculoComDescontoAplicado(){
        //Arrange
        Produto veiculo = new Veiculo(10000, 50, 1,"Fiat", "Uno", "Branco");
        double valorTotalEsperado = 16780.5;
        //Act
        double valorTotalRetornado = CalculadoraDesconto.calculaDesconto(veiculo, 10);
        //Assert
        assertEquals(valorTotalEsperado, valorTotalRetornado);
    }
}
