package br.com.cwi.treinamento.java.primitives.wrappers;

import br.com.cwi.treinamento.java.wrappers.IntegerCalculator;
import org.junit.Assert;
import org.junit.Test;

public class IntegerCalculatorTest {

    private IntegerCalculator calculator = new IntegerCalculator();

    @Test
    public void sum() {
        Assert.assertEquals(new Integer(7), calculator.sum(Integer.valueOf(5), Integer.valueOf(2)));
    }

    @Test
    public void subtract() {
        Assert.assertEquals(Integer.valueOf(3), calculator.subtract(Integer.valueOf(5), Integer.valueOf(2)));
    }

    @Test
    public void multiply() {
        Assert.assertEquals(Integer.valueOf(10), calculator.multiply(Integer.valueOf(5), Integer.valueOf(2)));
    }

    @Test
    public void divide() {
        Assert.assertEquals(Integer.valueOf(2), calculator.divide(Integer.valueOf(5), Integer.valueOf(2)));
    }

    @Test
    public void sumWithBoxing() {
        Assert.assertTrue(7 == calculator.sum(5, 2));
    }

    @Test
    public void subtractWithBoxing() {
        Assert.assertTrue(3 == calculator.subtract(5, 2));
    }

    @Test
    public void multiplyWithBoxing() {
        Assert.assertTrue(10 ==  calculator.multiply(5, 2));
    }

    @Test
    public void divideWithBoxing() {
        Assert.assertTrue(2 == calculator.divide(5, 2));
    }

}