package org.example.creational_patterns.factory;

public class AnimalFactory {

    private AnimalFactory() {}

    public static Animal getAnimal(AnimalType animalType) {
        return switch (animalType) {
            case DOG -> new Dog();
            case CAT -> new Cat();
            default -> throw new IllegalArgumentException("Invalid animal type");
        };
    }
}
