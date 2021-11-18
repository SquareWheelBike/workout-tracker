package src;

import java.util.*;
import java.io.*;

public class CSVReader {
    // import a CSV file as an ArrayList of ArrayLists
    public static ArrayList<ArrayList<String>> readCSV(String fileName) {
        ArrayList<ArrayList<String>> csv = new ArrayList<ArrayList<String>>();
        try {
            // open the file
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            // read each line
            while ((line = br.readLine()) != null) {
                // split the line into an array
                String[] tokens = line.split(",");
                // create a new ArrayList for each line
                ArrayList<String> lineArray = new ArrayList<String>();
                // add each token to the line ArrayList
                for (String token : tokens) {
                    lineArray.add(token);
                }
                // add the line ArrayList to the csv ArrayList
                csv.add(lineArray);
            }
            // close the file
            br.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return csv;
    }
}
