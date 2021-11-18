package src;

import java.util.*;
import java.io.*;

public class Exercises implements Serializable{
    private HashMap<String, ArrayList<String>> exercises;

    public Exercises() {
        this.exercises = new HashMap<>();
        this.testExercises2();
    }

    /**
     * adds new exercise to list if type exist, if type does not exist, return false
     * @param type String of type of exercise
     * @param exercise string of exercise
     * @return true if successfully added, false if type does not exist
     */
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

    }

    /**
     * gets list of exercises from type given
     * @param type String of type of exercise
     */
    public ArrayList<String> getExersicesFromType(String type){
        return this.exercises.get(type);
    }
    
    /**
     * gets list of types of exercises
     */
    public ArrayList<String> getTypeList(){
        return new ArrayList<String>(this.exercises.keySet());
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
    public static Exercises loadExercises(){
        Exercises exercises = null;
        try{
            FileInputStream fis = new FileInputStream("Exercises.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            exercises = (Exercises)ois.readObject();
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
        this.exercises.put("Arms", new ArrayList<>(Arrays.asList("Push Ups", "Curls")));
        this.exercises.put("Abs", new ArrayList<>(Arrays.asList("Sit Ups", "ab workouts")));
        this.exercises.put("Legs", new ArrayList<>(Arrays.asList("Squats", "T-bags")));
    }

    /**
     * Takes in the processed strings from the csv file and adds them to the exercises list
     */
    public void importExercises(ArrayList<ArrayList<String>> csv){
        for(ArrayList<String> line : csv){
            //TODO (cole): import csv data structure here
        }
    }
}
