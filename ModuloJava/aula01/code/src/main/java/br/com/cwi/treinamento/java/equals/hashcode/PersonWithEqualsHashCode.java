package br.com.cwi.treinamento.java.equals.hashcode;

import java.util.Objects;

public class PersonWithEqualsHashCode {

    private String cpf;
    private String name;
    private int age;

    public PersonWithEqualsHashCode(String cpf, String name, int age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithEqualsHashCode that = (PersonWithEqualsHashCode) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
