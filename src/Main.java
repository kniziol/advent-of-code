import com.adventofcode.day1.CaloriesFile;
import com.adventofcode.day1.CaloriesProcessor;
import com.adventofcode.day1.DefaultDataFileReader;
import com.adventofcode.day1.Elves;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("MISSING ARGUMENT: path of calories data file");
            System.exit(-1);
        }

        // Examples:
        // - src/com/adventofcode/day1/data/calories-demo.txt
        // - src/com/adventofcode/day1/data/calories-real.txt
        String filePath = args[0];
        CaloriesFile source = new CaloriesFile(filePath);

        LinkedList<String> lines = (new DefaultDataFileReader()).readAllLines(source);
        Elves elves = (new CaloriesProcessor()).process(lines);

        System.out.println(elves.findMaxCaloriesElf().calories());
    }
}
