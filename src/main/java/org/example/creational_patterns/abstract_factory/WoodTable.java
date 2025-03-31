package org.example.creational_patterns.abstract_factory;

public class WoodTable implements Table {
    @Override
    public void create() {
        System.out.println("Creating WoodTable");
    }
}
