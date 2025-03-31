package org.example.creational_patterns.factory;

public class Client {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal(AnimalType.DOG);
        System.out.println(animal.getSound());
    }
}
