/**
 * Temporary file to test individual features of the software
 */

 import src.*;
 import java.util.*;

public class Test {
    public static void main(String[] args) {
        // this imports all csv files into the database
        // adds them into an exercise table
        // prints out the exercise table
        List<List<String>> exerciseTable = CSVReader.readCSV("newList.csv", "src/data/");
        for (List<String> row : exerciseTable) {
            System.out.println(row.size() + " " + row);
        }
        System.exit(0);
    }
}
