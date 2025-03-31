package org.example.creational_patterns.abstract_factory;

public class PlasticChair implements Chair {
    @Override
    public void crate() {
        System.out.println("Creating PlasticChair");
    }
}
