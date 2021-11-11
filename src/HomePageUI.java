package src;

//import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class HomePageUI extends JPanel {
    
    private JLabel welcomeLabel;

    public HomePageUI() {
        //construct components
        welcomeLabel = new JLabel ("Welcome to Our Workout Program!",  SwingConstants.CENTER);

        add (welcomeLabel);

        welcomeLabel.setBounds (0, 10, 600, 20);
    }
}
