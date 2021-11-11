package GUI;

import java.awt.*;
import javax.swing.*;

public class HomePage extends JPanel {
    private JButton Exercises;
    private JButton Workouts;
    private JButton Schedule;
    private JButton Settings;

    public HomePage() {
        //adjust size and set layout
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);

        //construct components
        Exercises = new JButton ("Exercises");
        Workouts = new JButton ("Workouts");
        Schedule = new JButton ("Schedule");
        Settings = new JButton ("Settings");

        //add components
        add (Exercises);
        add (Workouts);
        add (Schedule);
        add (Settings);

        //set component bounds (only needed by Absolute Positioning)
        Exercises.setBounds (0, 500, 150, 100);
        Workouts.setBounds (150, 500, 150, 100);
        Schedule.setBounds (300, 500, 150, 100);
        Settings.setBounds (450, 500, 150, 100);
    }
}
