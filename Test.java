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
        ArrayList<String[]> exerciseTable = CSVReader.readCSV("newList.csv", "data/");
        System.out.println(exerciseTable);
        ManageExercise exercises = new ManageExercise();
        exercises.importExercises(exerciseTable);
        System.exit(0);
    }
}
