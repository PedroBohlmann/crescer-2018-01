package br.com.cwi.treinamento.java.equals.hashcode;

public class PersonWithoutEqualsHashCode {

    private String cpf;
    private String name;
    private int age;

    public PersonWithoutEqualsHashCode(String cpf, String name, int age) {
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

}
