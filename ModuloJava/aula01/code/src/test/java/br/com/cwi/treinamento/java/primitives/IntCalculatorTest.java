package br.com.cwi.treinamento.java.primitives;

import org.junit.Assert;
import org.junit.Test;

public class IntCalculatorTest {

    private IntCalculator calculator = new IntCalculator();

    @Test
    public void sum() {
        Assert.assertEquals(7, calculator.sum(5, 2));
    }

    @Test
    public void subtract() {
        Assert.assertEquals(3, calculator.subtract(5, 2));
    }

    @Test
    public void multiply() {
        Assert.assertEquals(10, calculator.multiply(5, 2));
    }

    @Test
    public void divide() {
        Assert.assertEquals(2, calculator.divide(5, 2));
    }

}