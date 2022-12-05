package com.adventofcode.day1;

import java.util.LinkedList;

public interface DataFileReader {
    public LinkedList<String> readAllLines(DataFile dataFile);
}
