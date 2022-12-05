package com.adventofcode.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertSame;

class CaloriesFileTest {
    @ParameterizedTest
    @MethodSource("provideFilePath")
    void getFilePath(String path) {
        CaloriesFile file = new CaloriesFile(path);
        assertSame(path, file.getFilePath());
    }

    @ParameterizedTest
    @MethodSource("provideFilePath")
    void isFilePathValid(String path, Boolean expected) {
        CaloriesFile file = new CaloriesFile(path);
        assertSame(expected, file.isFilePathValid());
    }

    private static Object[][] provideFilePath() {
        return new Object[][]{
                {"", false},
                {"/a/b/c", false},
                {"test/com/adventofcode/day1/CaloriesFileTest.java", true},
        };
    }
}