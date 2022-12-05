package com.adventofcode.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElvesTest {
    private Elves elves;

    public static Object[][] provideNonPositiveCalories() {
        return new Object[][]{
                {-100},
                {-1},
                {0},
        };
    }

    @BeforeEach
    void setUp() {
        elves = new Elves();
    }

    @Test
    void addElf() throws NoSuchFieldException, IllegalAccessException {
        Elf elf1 = new Elf(1);
        Elf elf2 = new Elf(2);

        elves.add(elf1);
        elves.add(elf2);

        ArrayList<?> collection = ElvesUtility.readElvesCollection(elves);
        assertEquals(new ArrayList<>(List.of(elf1, elf2)), collection);
    }

    @Test
    void addCalories() throws NoSuchFieldException, IllegalAccessException {
        Elf elf1 = new Elf(1);
        Elf elf2 = new Elf(2);

        elves.add(1);
        elves.add(2);

        ArrayList<?> collection = ElvesUtility.readElvesCollection(elves);
        assertEquals(new ArrayList<>(List.of(elf1, elf2)), collection);
    }

    @Test
    void findMaxCaloriesElfShouldReturnNullWhenNoElvesAdded() {
        assertNull(elves.findMaxCaloriesElf());
    }

    @Test
    void findMaxCaloriesElfShouldReturnExpectedElf() {
        Elf expected = new Elf(3);

        elves.add(new Elf(2));
        elves.add(new Elf(1));
        elves.add(expected);

        assertSame(expected, elves.findMaxCaloriesElf());
    }
}