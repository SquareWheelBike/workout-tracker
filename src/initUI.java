package src;

import java.awt.*;
import javax.swing.*;

public class initUI extends JFrame{

    private JPanel mainArea, taskBar;

    public initUI(){
        //setLayout(new GridLayout(2,1));
        setLayout(new BorderLayout()); 

        mainArea = new JPanel();        
        mainArea.add(new ExercisesUI());
        //mainArea.setBackground(Color.blue);
        add(mainArea); 
        
        taskBar = new JPanel();
        taskBar.add(new TaskBarUI());
        //taskBar.setBackground(Color.green);
        add(taskBar, BorderLayout.SOUTH); 

        setTitle("Workout");
        setAlwaysOnTop(true);
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
