package aula;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraInteligenteTest {
    //Soma
    @Test
    void testApresentaSomaDe5Com10(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da soma: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da soma: 15";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarSomar(calculadora,auxiliar,5,10);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testApresentaSomaDe256Com128(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da soma: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da soma: 384";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarSomar(calculadora,auxiliar,256,128);
        //Assert
        assertEquals(esperado,resultado);
    }
    //Subtracao
    @Test
    void testApresentaSubtracaoDe44Com11(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da substração: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da substração: 33";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarSubtracao(calculadora,auxiliar,44,11);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testApresentaSubtracaoDe666Com333(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da substração: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da substração: 333";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarSubtracao(calculadora,auxiliar,666,333);
        //Assert
        assertEquals(esperado,resultado);
    }
    //Divisao
    @Test
    void testApresentaDivisaoDe22Por11(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da divisão: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da divisão: 2.0";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarDivisao(calculadora,auxiliar,22,11);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testApresentaDivisaoDe72Por12(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da divisão: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da divisão: 6.0";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarDivisao(calculadora,auxiliar,72,12);
        //Assert
        assertEquals(esperado,resultado);
    }
    //Multiplicacao
    @Test
    void testApresentaMultiplicacaoDe6Por111(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da multiplicação: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da multiplicação: 666.0";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarMultiplicacao(calculadora,auxiliar,6,111);
        //Assert
        assertEquals(esperado,resultado);
    }
    @Test
    void testApresentaMultiplicacaoDe12Por12(){
        //Arrange
        Auxiliar auxiliar=new Auxiliar();
        auxiliar.setPrefixAndSufix("Resultado da multiplicação: ","");
        Calculadora calculadora=new Calculadora();
        String esperado= "Resultado da multiplicação: 144.0";
        CalculadoraInteligente calculadoraInteligente=new CalculadoraInteligente();
        //Act
        String resultado =calculadoraInteligente.apresentarMultiplicacao(calculadora,auxiliar,12,12);
        //Assert
        assertEquals(esperado,resultado);
    }
}