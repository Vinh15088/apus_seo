package org.example.creational_patterns.abstract_factory;

public class FurnitureFactory {

    private FurnitureFactory() {

    }

    public static FurnitureAbstractFactory getFactory(MaterialType materialType) {
        return switch (materialType) {
            case FLASTIC -> new PlasticFactory();
            case WOOD -> new WoodFactory();
            default -> throw new RuntimeException("Invalid materialType");
        };
    }
}
