package src;

import java.util.*;
import java.io.*;

public class Exercises implements Serializable{
    private ArrayList<String> exercisesList;

    public Exercises() {
        this.exercisesList = new ArrayList<>(); 
    }

    public void addExercise(String exercise){
        this.exercisesList.add(exercise);
    }
    public void removeExercise(String exercise){
        this.exercisesList.remove(exercise);
    }
    public ArrayList<String> getExersiseList(){
        return this.exercisesList;
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

    public void testExercises(){
        this.exercisesList.add("Push Ups");
        this.exercisesList.add("Sit Ups");
        this.exercisesList.add("Chin Ups");
    }
}
