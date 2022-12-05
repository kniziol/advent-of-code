package com.adventofcode.day1;

public class Calorie {
    private final String value;

    public Calorie(String value) {
        this.value = value;
    }

    public boolean isValid() {
        try {
            toInteger();
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public Integer toInteger() {
        return Integer.parseInt(value);
    }
}
