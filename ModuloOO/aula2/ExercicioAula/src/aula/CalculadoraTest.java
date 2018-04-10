package aula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    //Somas
    @Test
    void testarSomaCalculadoraRetornandoValor10(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =10;
        //Act
        int resultado=calc.somar(5,5);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testarSomaCalculadoraRetornandoValor33(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =33;
        //Act
        int resultado=calc.somar(30,3);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testarSomaCalculadoraRetornandoValor55(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =55;
        //Act
        int resultado=calc.somar(50,5);
        //Assert
        assertEquals(esperado,resultado);
    }
    //Subtrações
    @Test
    void testarSubtrairCalculadoraRetornandoValor0(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =0;
        //Act
        int resultado=calc.subtrair(5,5);
        //Assert
        assertEquals(esperado,resultado);
    }

    @Test
    void testarSubtrairCalculadoraRetornandoValor8(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =8;
        //Act
        int resultado=calc.subtrair(10,2);
        //Assert
        assertEquals(esperado,resultado);
    }

    @Test
    void testarSubtrairCalculadoraRetornandoValor10(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =10;
        //Act
        int resultado=calc.subtrair(20,10);
        //Assert
        assertEquals(esperado,resultado);
    }
    //Multiplicações
    @Test
    void testarMultiplicarCalculadoraRetornandoValor25(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =25;
        //Act
        double resultado=calc.multiplicar(5,5);
        //Assert
        assertEquals(esperado,resultado);
    }

    @Test
    void testarMultiplicarCalculadoraRetornandoValor12(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =12;
        //Act
        double resultado=calc.multiplicar(4,3);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testarMultiplicarCalculadoraRetornandoValor55(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =55;
        //Act
        double resultado=calc.multiplicar(11,5);
        //Assert
        assertEquals(esperado,resultado);
    }
    //Divisões
    @Test
    void testarDividirCalculadoraRetornandoValor2() {
        //Arrange
        Calculadora calc = new Calculadora();
        int esperado = 2;
        //Act
        double resultado = calc.dividir(10, 5);
        //Assert
        assertEquals(esperado, resultado);
    }
    @Test
    void testarDividirCalculadoraRetornandoValor10(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =10;
        //Act
        double resultado=calc.dividir(50,5);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testarDividirCalculadoraRetornandoValor5(){
        //Arrange
        Calculadora calc=new Calculadora();
        int esperado =5;
        //Act
        double resultado=calc.dividir(25,5);
        //Assert
        assertEquals(esperado,resultado);
    }
}
