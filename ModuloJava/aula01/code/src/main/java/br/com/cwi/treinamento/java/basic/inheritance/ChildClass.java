package br.com.cwi.treinamento.java.basic.inheritance;

import java.math.BigDecimal;

public class ChildClass extends BaseClass {

    private BigDecimal value;

    public ChildClass(String codigo, String descricao, BigDecimal value) {
        super(codigo, descricao);
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public void overridableMethod() {
        System.out.println("child method");
    }

//    @Override
//    public void nonOverridableMethod() {
//        System.out.println("child method");
//    }
}
