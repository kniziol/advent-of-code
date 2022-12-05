package com.adventofcode.day1;

import java.io.File;

public class CaloriesFile extends File implements DataFile {
    private final String filePath;

    public CaloriesFile(String filePath) {
        super(filePath);
        this.filePath = filePath;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public Boolean isFilePathValid() {
        if (filePath.isEmpty()) {
            return false;
        }

        return exists() && !isDirectory();
    }
}
