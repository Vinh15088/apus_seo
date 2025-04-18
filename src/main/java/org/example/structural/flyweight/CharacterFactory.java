package org.example.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.lang.Character;

public class CharacterFactory {

    private static final Map<Character, ICharacter> characters = new HashMap<Character, ICharacter>();

    public static ICharacter createCharacter(Character character) {
        if(!characters.containsKey(character)) {
            characters.put(character, new ConcreteCharacter(character));

            System.out.println("Creating new character: " + character);
        }

        return characters.get(character);
    }
}
