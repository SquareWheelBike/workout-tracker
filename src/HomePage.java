package src;

//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class HomePage extends JPanel {
//    private JButton workouts;
//    private JButton schedule;
//    private JButton settings;
//    private JButton exercise;
    private JLabel welcomeLabel;

    public HomePage() {
        //construct components
        welcomeLabel = new JLabel ("Welcome to Our Workout Program!",  SwingConstants.CENTER);

        add (welcomeLabel);

        welcomeLabel.setBounds (0, 10, 600, 20);
    }
}
