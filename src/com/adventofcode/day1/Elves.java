package com.adventofcode.day1;

import java.util.ArrayList;

public class Elves {
    private final ArrayList<Elf> collection;

    public Elves() {
        this.collection = new ArrayList<>();
    }

    public void add(Elf elf) {
        collection.add(elf);
    }

    public void add(Integer calories) {
        collection.add(new Elf(calories));
    }

    public Elf findMaxCaloriesElf() {
        if (collection.isEmpty()) {
            return null;
        }

        Elf maxElf = new Elf(0);

        for (Elf elf : collection) {
            if (elf.calories() < maxElf.calories()) {
                continue;
            }

            maxElf = elf;
        }

        return maxElf;
    }
}
