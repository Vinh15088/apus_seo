package org.example.creational_patterns.abstract_factory;

public class PlasticTable implements Table{
    @Override
    public void create() {
        System.out.println("Creating PlasticTable");
    }
}
