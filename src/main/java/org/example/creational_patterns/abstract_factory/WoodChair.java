package org.example.creational_patterns.abstract_factory;

public class WoodChair implements Chair {
    @Override
    public void crate() {
        System.out.println("Create WoodChair");
    }
}
