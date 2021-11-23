package src;

import java.util.*;
import java.io.*;

public class ManageExercise implements Serializable{
    
    //private HashMap<String, ArrayList<String>> exercises;
    private ArrayList<Exercise> exerciseList;
    private ArrayList<ArrayList<String>> csv;
    private static final long serialVersionUID = 1L; // VERSION NUMBER, needed for serialization

    public ManageExercise() {
        this.exerciseList = new ArrayList<Exercise>();
        //testExercises2();
        this.csv = CSVReader.readCSV("List.csv", "src/data/");
        importExercises(csv);
    }

 
    /**
     * adds new exercise to list if type exist, if type does not exist, return false
     * @param type String of type of exercise
     * @param exercise string of exercise
     * @return true if successfully added, false if type does not exist
     
    public boolean addExercise(String type, String exercise){
        if(this.exercises.containsKey(type)){
            ArrayList<String> list = this.getExersicesFromType(type);
            list.add(exercise);
            this.exercises.put(type, list);
            return true;
        }
        else{
            return false;
        }

    }*/

    /**
     * gets the Exercise of exercise by id
     * @param type
     * @return
     */
    public Exercise getExerciseByID(Integer ID){
        for(Exercise e: exerciseList){
            if(e.getID() == ID){
                return e;
            }
        }
        return null;
    }

    public ArrayList<Exercise> getExerciseList(){
        return this.exerciseList;
    }

    
    /**
     * gets list of exercises from type given
     * @param type String of type of exercise
     */
    public ArrayList<String> getExersicesFromType(String type){
        ArrayList<String> nameList = new ArrayList<>();
        for(Exercise e : this.exerciseList){
            if(e.getType().equals(type)){
                nameList.add(e.getName());
            }
        }
        return nameList;
    }

    public Exercise getExerciseByName(String name){
        ArrayList<Exercise> list = new ArrayList<>();
        for(Exercise e : this.exerciseList){
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }
    
    
    /**
     * gets list of types of exercises
     */ 
    public ArrayList<String> getTypeList(){
        ArrayList<String> typeList = new ArrayList<>();
        for(Exercise e : this.exerciseList){
            if(!typeList.contains(e.getType())){
                typeList.add(e.getType());
            }
        }
        return typeList;
    }

    // store serialized exercise list for next session
    public void storeExercises(){
        try{
            FileOutputStream fos = new FileOutputStream("Exercises.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // load serialized exercise list for next session
    public static ManageExercise loadExercises(){
        ManageExercise exercises = null;
        try{
            FileInputStream fis = new FileInputStream("Exercises.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            exercises = (ManageExercise)ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return exercises;
    }

    public void testExercises2(){
        exerciseList.add(new Exercise(1, "Legs", "Squat", "Squat.png"));
        exerciseList.add(new Exercise(3, "Legs", "Lunges", "Lunge.png"));
        exerciseList.add(new Exercise("Legs", "Deadlift", "Deadl.png"));
        exerciseList.add(new Exercise(19, "Abs", "Situps", "Situp.png"));
        exerciseList.add(new Exercise(20, "Abs", "Plank", "Plank.png"));
        exerciseList.add(new Exercise("Arms", "Bicep Curl", "Bicep.png"));
        exerciseList.add(new Exercise("Arms", "Hammer Curl", "Hamme.png"));
    }

    /**
     * Takes in the processed strings from the csv file and adds them to the exercises list
     */
    public void importExercises(ArrayList<ArrayList<String>> csv){
        // NOTE: any optional entries MUST go at the end columns of the CSV file (ie extras)

        ArrayList<String> header = csv.remove(0); // remove header from csv, store in its own reference as a list
        HashMap<String, Integer> headerMap = new HashMap<>(); // create a map of the header entries to their index in the array
        for (String s : header) {
            headerMap.put(s.toLowerCase(), header.indexOf(s.toString()));
        }

        for (ArrayList<String> line : csv) {
            // create a new exercise object with the data from the csv line
            // since this constructor just fills blank fields with null, we can just use the default constructor mapped to knows header entries
            int eid;
            if (headerMap.get("id") == null) {
                eid = -1;
            } else {
                eid = Integer.parseInt(line.get(headerMap.get("id")));
            }
            String extra1;
            if (headerMap.get("extra1") == null || headerMap.get("extra1") >= line.size()) {
                extra1 = null;
            } else {
                extra1 = line.get(headerMap.get("extra1"));
            }
            String extra2;
            if (headerMap.get("extra2") == null || headerMap.get("extra2") >= line.size()) {
                extra2 = null;
            } else {
                extra2 = line.get(headerMap.get("extra2"));
            }
            String description;
            if (headerMap.get("description") == null || headerMap.get("description") >= line.size()) {
                description = null;
            } else {
                description = line.get(headerMap.get("description"));
            }
            Exercise e = new Exercise(eid, line.get(headerMap.get("type")), line.get(headerMap.get("name")), line.get(headerMap.get("imagename")), extra1, extra2, description);
            // add the exercise to the list
            this.exerciseList.add(e);
        }

    }

}
