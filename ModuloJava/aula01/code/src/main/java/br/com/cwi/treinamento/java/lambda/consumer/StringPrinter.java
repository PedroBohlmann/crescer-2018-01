package br.com.cwi.treinamento.java.lambda.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StringPrinter {

    public static void main(String[] args) {
        StringPrinter printer = new StringPrinter();

        printer.printStrings6();
    }

    public void printStrings() {
        List<String> strings = Arrays.asList("Brasil, França, Itália");

        for (String s : strings) {
            System.out.println(s);
        }
    }

    public void printStrings2() {
        List<String> strings = Arrays.asList("Brasil, França, Itália");

        Consumer<String> consumer = new Printer();

        strings.forEach(consumer);
    }

    public void printStrings3() {
        List<String> strings = Arrays.asList("Brasil, França, Itália");

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public void printStrings4() {
        List<String> strings = Arrays.asList("Brasil, França, Itália");

        strings.forEach((String s) -> { System.out.println(s); }
        );
    }

    public void printStrings5() {
        List<String> strings = Arrays.asList("Brasil, França, Itália");

        strings.forEach(s -> System.out.println(s));
    }

    public void printStrings6() {
        List<String> strings = Arrays.asList("Brasil, França, Itália");

        strings.forEach(System.out::println);
    }

}

class Printer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }

}

