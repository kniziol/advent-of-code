package com.adventofcode.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertSame;

class CalorieTest {
    public static Object[][] provideValue() {
        return new Object[][]{
                {"", false},
                {"abc", false},
                {"-1", true},
                {"0", true},
                {"123", true},
        };
    }

    public static Object[][] provideNumericValue() {
        return new Object[][]{
                {"-1", -1},
                {"0", 0},
                {"123", 123},
        };
    }

    @ParameterizedTest
    @MethodSource("provideValue")
    void isValid(String value, Boolean expected) {
        Calorie calorie = new Calorie(value);
        assertSame(expected, calorie.isValid());
    }

    @ParameterizedTest
    @MethodSource("provideNumericValue")
    void toInteger(String value, Integer expected) {
        Calorie calorie = new Calorie(value);
        assertSame(expected, calorie.toInteger());
    }
}