package com.adventofcode.day1;

import java.util.LinkedList;

public class CaloriesProcessor implements DataFileProcessor {
    @Override
    public Elves process(LinkedList<String> calories) {
        Elves elves = new Elves();
        int perElf = 0;

        for (String calorieChunk : calories) {
            boolean lastChunk = calorieChunk.isEmpty();

            boolean noMoreChunks = calorieChunk.equals(calories.getLast());
            Calorie calorie = new Calorie(calorieChunk);

            if (noMoreChunks && calorie.isValid()) {
                perElf += calorie.toInteger();
                elves.add(perElf);
            }

            if (lastChunk) {
                elves.add(perElf);
                perElf = 0;
                continue;
            }

            if (!calorie.isValid()) {
                continue;
            }

            perElf += calorie.toInteger();
        }

        return elves;
    }
}
