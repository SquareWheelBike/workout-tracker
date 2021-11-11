package src;

import java.awt.*;
import javax.swing.*;

public class initUI extends JFrame{

    private JPanel mainArea;

    public initUI(){


        mainArea = new JPanel();
        mainArea.setLayout(new GridLayout(2,1));
        mainArea.add(new HomePage());
        add(mainArea);

        //JPanel HomePage = new HomePage();
        
        
        mainArea.add(new TaskBarUI());

        setTitle("Workout");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//        JFrame frame = new JFrame ("Workout");
//        frame.setAlwaysOnTop(true);
//        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add (new HomePage());
//        frame.getContentPane().add (new TaskBarUI());
//        frame.pack();
//        frame.setVisible (true);
    }
}
