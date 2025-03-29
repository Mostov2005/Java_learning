package org.knit.solutions.ClassesSem2.lab5.task16;

public class TextCharacter {
    private final char symbol; // Внутреннее состояние (код символа)

    public TextCharacter(char symbol) {
        this.symbol = symbol;
    }

    public void render(int x, int y, String style) {
        System.out.println("Символ '" + symbol + "' отрисован в (" + x + ", " + y + ") со стилем '" + style + "'");
    }
}
