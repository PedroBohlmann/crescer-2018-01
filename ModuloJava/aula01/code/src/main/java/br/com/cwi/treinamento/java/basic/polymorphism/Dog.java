package br.com.cwi.treinamento.java.basic.polymorphism;

public class Dog extends Animal {

    @Override
    protected void move() {
        System.out.println("walk");
    }

    @Override
    protected void talk() {
        System.out.println("bark");
    }

}
