package org.example.creational_patterns.abstract_factory;

public class Client {
    public static void main(String[] args) {
        FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.FLASTIC);

        Chair chair = factory.createChair();
        chair.crate();

        Table table = factory.createTable();
        table.create();
    }
}
