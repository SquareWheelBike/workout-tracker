import java.awt.*;
import javax.swing.*;

import GUI.HomePage;

public class initUI {

    public initUI(){
        JFrame frame = new JFrame ("Workout");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new HomePage());
        frame.pack();
        frame.setVisible (true);
    }
}
