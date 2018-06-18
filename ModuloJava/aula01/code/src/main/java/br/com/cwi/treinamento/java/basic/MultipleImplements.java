package br.com.cwi.treinamento.java.basic;

import java.time.LocalDateTime;

public class MultipleImplements implements SimpleInterface, AnotherSimpleInterface {

    @Override
    public void doSimpleTask() {
        System.out.println("done!");
    }

    @Override
    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

}
