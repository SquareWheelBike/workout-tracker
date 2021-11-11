package src;

import java.util.ArrayList;

public class Exercises{
    private ArrayList<String> exercisesList;

    public Exercises() {
        ArrayList<String> exercisesList = new ArrayList<>(); 
        testExercises();
    }

    public void addExercise(String exercise){
        exercisesList.add(exercise);
    }
    public void removeExercise(String exercise){
        exercisesList.remove(exercise);
    }
    public ArrayList<String> getExersiseList(){
        return exercisesList;
    }

    public void testExercises(){
        exercisesList.add("Push Ups");
        exercisesList.add("Sit Ups");
        exercisesList.add("Chin Ups");
    }
}
