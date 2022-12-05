package com.adventofcode.day1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class ElvesUtility {
    public static ArrayList<?> readElvesCollection(Elves elves) throws NoSuchFieldException, IllegalAccessException {
        Field field = Elves.class.getDeclaredField("collection");
        field.setAccessible(true);
        Object value = field.get(elves);

        return new ArrayList<>((Collection<?>) value);
    }
}
