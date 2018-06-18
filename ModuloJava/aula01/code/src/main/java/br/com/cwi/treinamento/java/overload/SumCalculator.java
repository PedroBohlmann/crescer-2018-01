package br.com.cwi.treinamento.java.overload;

import java.math.BigDecimal;

public class SumCalculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public Float sum(Float a, Float b) {
        return a + b;
    }

    public Double sum(Double a, Double b) {
        return a + b;
    }

    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        if (a == null || b == null) {
            return null;
        }

        return a.add(b);
    }

}
