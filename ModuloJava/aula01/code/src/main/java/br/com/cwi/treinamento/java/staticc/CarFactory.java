package br.com.cwi.treinamento.java.staticc;

public class CarFactory {

    public static Car getFerrari() {
        return new Ferrari();
    }

    public static Car getMcLaren() {
        return new McLaren();
    }

}
