package com.adventofcode.day1;

import java.io.*;
import java.text.MessageFormat;
import java.util.LinkedList;

public class DefaultDataFileReader implements DataFileReader {
    @Override
    public LinkedList<String> readAllLines(DataFile dataFile) {
        String filePath = dataFile.getFilePath();

        if (!dataFile.isFilePathValid()) {
            String message = MessageFormat.format("Cannot open calories data file: {0}", filePath);
            throw new RuntimeException(message);
        }

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader((File) dataFile));
        } catch (FileNotFoundException e) {
            String message = MessageFormat.format("An error occurred while trying to open file: {0}", filePath);
            throw new RuntimeException(message);
        }

        LinkedList<String> lines = new LinkedList<>();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }
}
