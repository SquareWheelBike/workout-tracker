package src;

import java.util.*;
import java.io.*;

public class ManageExercise implements Serializable{
    
    //private HashMap<String, ArrayList<String>> exercises;
    private ArrayList<Exercise> exerciseList;

    public ManageExercise() {
        this.exerciseList = new ArrayList<>();
        this.testExercises2();
        //load exercises from file
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
        exerciseList.add(new Exercise("Legs", "Squat", "Squat.png"));
        exerciseList.add(new Exercise("Legs", "Lunges", "Lunge.png"));
        exerciseList.add(new Exercise("Legs", "Deadlift", "Deadl.png"));
        exerciseList.add(new Exercise("Abs", "Situps", "Situp.png"));
        exerciseList.add(new Exercise("Abs", "Plank", "Plank.png"));
        exerciseList.add(new Exercise("Arms", "Bicep Curl", "Bicep.png"));
        exerciseList.add(new Exercise("Arms", "Hammer Curl", "Hamme.png"));
    }

    /**
     * Takes in the processed strings from the csv file and adds them to the exercises list
     */
    public void importExercises(ArrayList<ArrayList<String>> csv){
        for(ArrayList<String> line : csv){
            //TODO (cole): import csv data structure here
            //Should we do a new version like the one on the excel sheet page 2?
        }
    }
}
