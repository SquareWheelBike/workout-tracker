package src;

//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class TaskBarUI extends JPanel {
    private JButton workouts;
    private JButton schedule;
    private JButton settings;
    private JButton exercise;

    public TaskBarUI() {
        //construct components
        workouts = new JButton ("Workouts");
        schedule = new JButton ("Schedule");
        settings = new JButton ("Settings");
        exercise = new JButton ("Exersices");
        
        //set component bounds (only needed by Absolute Positioning)
        exercise.setBounds(0, 500, 150, 100);
        workouts.setBounds(150, 500, 150, 100);
        schedule.setBounds(300, 500, 150, 100);
        settings.setBounds(450, 500, 150, 100);

        //add components
        add (exercise);
        add (workouts);
        add (schedule);
        add (settings);


    }

    public JButton getWorkoutButton(){
        return workouts;
    } 
    public JButton getScheduleButton(){
        return schedule;
    } 
    public JButton getSettingsButton(){
        return settings;
    } 
    public JButton getExerciseButton(){
        return exercise;
    } 
}
