package br.com.cwi.treinamento.java.basic.polymorphism;

public class Bird extends Animal {

    @Override
    protected void move() {
        System.out.println("swim");
    }

    @Override
    protected void talk() {
        System.out.println("chirp");
    }
}
