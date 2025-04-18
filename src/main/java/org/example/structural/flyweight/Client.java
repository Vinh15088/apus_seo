package org.example.structural.flyweight;

public class Client {
    public static void main(String[] args) {

        String text = "HELLO WORLD";

        for (char c : text.toCharArray()) {
            if(Character.isLetter(c)) {
                ICharacter iCharacter = CharacterFactory.createCharacter(c);

                CharacterContext context = new CharacterContext(14, "Black", "Bold");

                iCharacter.display(context);
            }
        }
    }
}
