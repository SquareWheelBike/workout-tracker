package src;

import java.util.*;
import java.io.*;

public class CSVReader {
    // import a CSV file as an ArrayList of ArrayLists
    public static ArrayList<ArrayList<String>> readCSV(String fileName, String path) {
        ArrayList<ArrayList<String>> csv = new ArrayList<>();
        try {
            // open the file
            FileInputStream fis = new FileInputStream(path + fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            // read each line
            while ((line = br.readLine()) != null) {
                // split the line into an array
                ArrayList<String> row = new ArrayList<>();
                // add each element to the row
                for (String element : line.split(",")) {
                    row.add(element);
                }
                // add the row to the csv
                csv.add(row);
            }
            // close the file
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return csv;
    }
}
