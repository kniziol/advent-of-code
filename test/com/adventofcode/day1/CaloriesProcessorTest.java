package com.adventofcode.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaloriesProcessorTest {
    CaloriesProcessor caloriesProcessor;

    @BeforeEach
    void setUp() {
        caloriesProcessor = new CaloriesProcessor();
    }

    @Test
    void processShouldReturnEmptyElvesCollectionWhenNoCaloriesProvided() throws NoSuchFieldException, IllegalAccessException {
        LinkedList<String> calories = new LinkedList<>();
        Elves elves = caloriesProcessor.process(calories);

        ArrayList<?> collection = ElvesUtility.readElvesCollection(elves);
        ArrayList<Elf> empty = new ArrayList<>();

        assertEquals(empty, collection);
    }

    @Test
    void processShouldReturnEmptyElvesCollectionWhenCaloriesAreNotNumbers() throws NoSuchFieldException, IllegalAccessException {
        LinkedList<String> calories = new LinkedList<>(List.of("aa", "bb", "cc"));
        Elves elves = caloriesProcessor.process(calories);

        ArrayList<?> collection = ElvesUtility.readElvesCollection(elves);
        ArrayList<Elf> empty = new ArrayList<>();

        assertEquals(empty, collection);
    }

    @ParameterizedTest
    @MethodSource("provideCalories")
    void processShouldReturnElvesCollection(List<String> caloriesValues, ArrayList<Elf> expected) throws NoSuchFieldException, IllegalAccessException {
        LinkedList<String> calories = new LinkedList<>(caloriesValues);
        Elves elves = caloriesProcessor.process(calories);

        ArrayList<?> collection = ElvesUtility.readElvesCollection(elves);
        assertEquals(expected, collection);
    }

    private static Object[][] provideCalories() {
        return new Object[][]{
                {
                        List.of("0", "1", "", "2"),
                        new ArrayList<>(List.of(new Elf(1), new Elf(2)))
                },
                {
                        List.of("1", "2", "3", "", "4"),
                        new ArrayList<>(List.of(new Elf(6), new Elf(4)))
                },
                {
                        List.of("1", "", "2", "", "3"),
                        new ArrayList<>(List.of(new Elf(1), new Elf(2), new Elf(3)))
                },
                {
                        List.of("1", "2", "3", "4"),
                        new ArrayList<>(List.of(new Elf(10)))
                },
        };
    }
}