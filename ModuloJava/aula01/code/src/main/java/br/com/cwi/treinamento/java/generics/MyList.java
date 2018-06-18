package br.com.cwi.treinamento.java.generics;

import java.util.Arrays;

public class MyList {

    private Object[] elements = new Object[0];

    public Object get(int index) {
        return elements[index];
    }

    public void add(Object element) {
        int position = elements.length + 1;

        elements = Arrays.copyOf(elements, position);

        elements[position] = element;
    }

}
