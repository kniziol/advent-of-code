package com.adventofcode.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DefaultDataFileReaderTest {
    private DefaultDataFileReader reader;

    @BeforeEach
    void setUp() {
        reader = new DefaultDataFileReader();
    }

    @Test
    void readAllLinesShouldThrowExceptionIfFilePathIsEmpty() {
        DataFile dataFile = new CaloriesFile("");

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> reader.readAllLines(dataFile)
        );

        assertTrue(thrown.getMessage().contentEquals("Cannot open calories data file: "));
    }

    @Test
    void readAllLinesShouldThrowExceptionIfFileDoesNotExist() {
        String filePath = "/not/existing/file.txt";
        DataFile dataFile = new CaloriesFile(filePath);

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> reader.readAllLines(dataFile)
        );

        assertTrue(thrown.getMessage().contentEquals("Cannot open calories data file: " + filePath));
    }

    @Test
    void readAllLinesShouldThrowExceptionIfPathOfDirectoryProvided() {
        String filePath = "test/com/adventofcode/day1/data";
        DataFile dataFile = new CaloriesFile(filePath);

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> reader.readAllLines(dataFile)
        );

        assertTrue(thrown.getMessage().contentEquals("Cannot open calories data file: " + filePath));
    }

    @Test
    void readAllLinesShouldReturnNoLinesIfFileIsEmpty() {
        DataFile dataFile = new CaloriesFile("test/com/adventofcode/day1/data/empty.csv");
        LinkedList<String> lines = reader.readAllLines(dataFile);

        LinkedList<String> empty = new LinkedList<>();
        assertEquals(empty, lines);
    }

    @Test
    void readAllLinesShouldReturnLinesIfFileIsNotEmpty() {
        DataFile dataFile = new CaloriesFile("test/com/adventofcode/day1/data/calories.csv");
        LinkedList<String> lines = reader.readAllLines(dataFile);

        LinkedList<String> expected = new LinkedList<>(List.of("1", "2", "", "3", "", "4", "5"));
        assertEquals(expected, lines);
    }
}