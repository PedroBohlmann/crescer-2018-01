package br.com.cwi.treinamento.java.generics;

import java.util.Comparator;
import java.util.List;

public class MinElement {

    public static <T> T min(List<T> elements, Comparator<T> comparator) {
        if (elements.isEmpty()) {
            throw new IllegalArgumentException("List is empty, cannot find minimum");
        }

        T lowestElement = elements.get(0);

        for(int i = 1; i < elements.size(); i++) {
            T element = elements.get(i);

            if (comparator.compare(element, lowestElement) < 0) {
                lowestElement = element;
            }
        }

        return lowestElement;
    }
}
