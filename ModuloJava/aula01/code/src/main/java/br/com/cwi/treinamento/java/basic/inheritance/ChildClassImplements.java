package br.com.cwi.treinamento.java.basic.inheritance;

import br.com.cwi.treinamento.java.basic.AnotherSimpleInterface;
import br.com.cwi.treinamento.java.basic.SimpleInterface;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ChildClassImplements extends BaseClass implements SimpleInterface, AnotherSimpleInterface {

    private BigDecimal value;

    public ChildClassImplements(String codigo, String descricao, BigDecimal value) {
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
    public void doSimpleTask() {
        System.out.println("done!");
    }

    @Override
    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }
}
