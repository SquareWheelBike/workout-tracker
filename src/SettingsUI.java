package src;


//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;


public class SettingsUI extends JPanel implements ActionListener {
    private initUI parentUI;

//    private JRadioButton Workout1, Workout2;
//    private JLabel selectLabel;

    private JButton jcomp1;
    private JButton jcomp2;
    private JButton jcomp3;


    public SettingsUI(initUI parentUI) {
        this.parentUI = parentUI;

        //construct components
        jcomp1 = new JButton ("Edit User");
        jcomp2 = new JButton ("Change User");
        jcomp3 = new JButton ("Reset To Defult");

        //add components
        add (jcomp1);
        add (jcomp2);
        add (jcomp3);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (25, 35, 210, 55);
        jcomp2.setBounds (25, 110, 210, 55);
        jcomp3.setBounds (25, 190, 210, 60);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void setExercise(String option){

    }

    public void updateFrame(){
        parentUI.updateDisplay();
    }
}
