package src;

//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class TaskBarUI extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L; // VERSION NUMBER, needed for serialization
    private JButton workouts;
    private JButton schedule;
    private JButton settings;
    private JButton exercise;
    private initUI parentUI;

    public TaskBarUI(initUI parentUI) {

        this.parentUI = parentUI;

        // construct components
        exercise = new JButton("Exersices");
        workouts = new JButton("Workouts");
        //schedule = new JButton("Schedule");
        settings = new JButton("Settings");

        exercise.addActionListener(this);
        //schedule.addActionListener(this);
        settings.addActionListener(this);
        workouts.addActionListener(this);

        // add components
        add(exercise);
        add(workouts);
        //add(schedule);
        add(settings);
    }

    public JButton getWorkoutButton() {
        return workouts;
    }

    public JButton getScheduleButton() {
        return schedule;
    }

    public JButton getSettingsButton() {
        return settings;
    }

    public JButton getExerciseButton() {
        return exercise;
    }

    public void actionPerformed(ActionEvent e) {
        // debug
        System.out.print("TaskBarUI: ");  
        if(e.getSource() == exercise){
            parentUI.setMainArea(1);
            System.out.println("Exercise button pressed");
        }
        else if(e.getSource() == schedule){
            parentUI.setMainArea(3);
            System.out.println("Schedule button pressed");
        }
        else if(e.getSource() == settings){
            parentUI.setMainArea(4);
            System.out.println("Settings button pressed");
        }
        else if(e.getSource() == workouts){
            parentUI.setMainArea(2);
            System.out.println("Workouts button pressed");
        }
        else{
            System.out.println("Unknown button pressed");
        }
    }

}
