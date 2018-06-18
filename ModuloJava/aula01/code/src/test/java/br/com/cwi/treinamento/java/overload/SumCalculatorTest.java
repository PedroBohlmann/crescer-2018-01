package br.com.cwi.treinamento.java.overload;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SumCalculatorTest {

    private SumCalculator calculator = new SumCalculator();

    @Test
    public void deveSomarInt() {
        Assert.assertEquals(7, calculator.sum(5, 2));
    }

    @Test
    public void deveSomarInteger() {
        Assert.assertEquals(Integer.valueOf(7), calculator.sum(Integer.valueOf(5), Integer.valueOf(2)));
    }

    @Test
    public void deveSomarFloat() {
        Assert.assertEquals(Float.valueOf(7.7f), calculator.sum(Float.valueOf(5.2f), Float.valueOf(2.5f)));
    }

    @Test
    public void deveSomarDouble() {
        Assert.assertEquals(Double.valueOf(7.7d), calculator.sum(Double.valueOf(5.2d), Double.valueOf(2.5d)));
    }

    @Test
    public void deveSomarBigDecimal() {
        Assert.assertEquals(new BigDecimal("0.70"), calculator.sum(new BigDecimal("0.35"), new BigDecimal("0.35")));
    }

    //@Test
    public void deveSomarBigDecimalDoJeitoErradoPorCausaDisso() {
        Assert.assertEquals(new BigDecimal(0.70), calculator.sum(new BigDecimal(0.35), new BigDecimal(0.35)));
    }

}