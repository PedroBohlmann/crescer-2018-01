package br.com.cwi.treinamento.java.acessors.constructor;

public class PrivateConstructor {

    private PrivateConstructor() {

    }

    public static PrivateConstructor get() {
        return new PrivateConstructor();
    }
}
