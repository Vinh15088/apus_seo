package org.example.structural.flyweight;

// concrete flyweight
public class ConcreteCharacter implements ICharacter {

    private final char character; // intrinsic

    public ConcreteCharacter(char character) {
        this.character = character;
    }

    @Override
    public void display(CharacterContext characterContext) {
        System.out.println("ICharacter: " + character);
        System.out.println("Fontsize: " + characterContext.getFontSize() + "; " +
                "Color: " + characterContext.getColor() + "; " +
                "FontStyle: " + characterContext.getFontStyle());
    }
}
