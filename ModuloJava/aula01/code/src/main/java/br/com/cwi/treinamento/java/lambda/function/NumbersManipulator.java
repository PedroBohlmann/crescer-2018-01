package br.com.cwi.treinamento.java.lambda.function;

import br.com.cwi.treinamento.java.finall.Person;

import java.util.List;

import static java.util.Arrays.asList;

public class NumbersManipulator {

    public static void main(String[] args) {
        Person p1 = new Person("João", 30);
        Person p2 = new Person("Maria", 25);
        Person p3 = new Person("José", 15);

        List<Person> people = asList(p1, p2, p3);

        int max = people.stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println(max);
    }
}
