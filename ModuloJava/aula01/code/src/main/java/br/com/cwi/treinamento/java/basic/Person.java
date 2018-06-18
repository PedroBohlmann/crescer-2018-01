package br.com.cwi.treinamento.java.basic;

public class Person {

    // constantes
    private static final int MAX_AGE = 120;

    // atributos
    private String name;
    private int age;

    // construtores
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // métodos
    public String sayHello() {
        return "Hello! My name is " + this.name;
    }

    public String compareAge(int age) {
        if (this.age > age) {
            return "I'm older";
        } else if (this.age < age) {
            return "I'm younger";
        } else {
            return "I have the same age";
        }
    }

    // getters and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
