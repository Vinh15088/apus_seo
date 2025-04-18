package org.example.structural.flyweight;

public class CharacterContext {
    private final int fontSize;
    private final String color;
    private final String fontStyle;

    public CharacterContext(int fontSize, String color, String fontStyle) {
        this.fontSize = fontSize;
        this.color = color;
        this.fontStyle = fontStyle;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getColor() {
        return color;
    }

    public String getFontStyle() {
        return fontStyle;
    }
}
