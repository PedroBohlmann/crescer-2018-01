package br.com.cwi.treinamento.java.basic.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {

    private List<Animal> animals = new ArrayList<>();

    public void run() {

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Bird bird1 = new Bird();
        Bird bird2 = new Bird();
        Bird bird3 = new Bird();

        animals.add(dog1);
        animals.add(bird1);
        animals.add(bird2);
        animals.add(dog2);
        animals.add(dog3);
        animals.add(bird3);

        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            animal.move();
            animal.talk();
            System.out.println("-----");
        }

    }

}
