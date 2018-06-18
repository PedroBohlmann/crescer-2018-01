package br.com.cwi.treinamento.java.generics;

import java.util.Arrays;

public class MyGenericList<T> {

    private Object[] elements = new Object[0];

    public T get(int index) {
        return (T)elements[index];
    }

    public void add(T element) {
        int position = elements.length + 1;

        elements = Arrays.copyOf(elements, position);

        elements[position] = element;
    }

}
