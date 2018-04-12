package test;

import org.junit.jupiter.api.Test;
import produtos.Veiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VeiculoTest {
    @Test
    void testaPrecoDoVeiculoFiatUno(){
        Veiculo carro=new Veiculo(10000,0.10,0.2,"Fiat","Uno","Azul");
        double valorEsperado=13673;
        double valorObtido= carro.calcularValorTotal();

        assertEquals(valorEsperado,valorObtido);
    }

    @Test
    void testaPrecoDoVeiculoSupra(){
        Veiculo carro=new Veiculo(10000,0.10,1,"Fiat","Uno","Azul");
        double valorEsperado=14333;
        double valorObtido= carro.calcularValorTotal();

        assertEquals(valorEsperado,valorObtido);
    }
}