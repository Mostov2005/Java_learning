package org.knit.solutions.ClassesSem2.lab5.task16;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static final Map<Character, TextCharacter> characters = new HashMap<>();

    public static TextCharacter getCharacter(char symbol) {
        characters.putIfAbsent(symbol, new TextCharacter(symbol));
        return characters.get(symbol);
    }
}
