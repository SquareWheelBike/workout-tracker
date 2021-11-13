package src;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;


public class WorkoutsUI extends JPanel implements ActionListener {
    private initUI parentUI;

//    private JRadioButton Workout1, Workout2;
//    private JLabel selectLabel;

    private JRadioButton Workout1, Workout2;
    private JLabel selectLabel;
    private JTextArea jcomp4;

    public WorkoutsUI(initUI parentUI) {
        this.parentUI = parentUI;

        selectLabel = new JLabel ("Please Select a Workout");
        add (selectLabel);

        Workout1 = new JRadioButton ("Abs Burner");
        Workout1.addActionListener(this);
        add (Workout1);
        Workout2 = new JRadioButton ("Fitness");
        Workout2.addActionListener(this);
        add (Workout2);

        jcomp4 = new JTextArea (5, 5);
        add (jcomp4);

        //adjust size and set layout
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);

        //Add to group to only allow 1 selected
        ButtonGroup group = new ButtonGroup();
        group.add(Workout1);
        group.add(Workout2);


        //set component bounds (only needed by Absolute Positioning)
        selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectLabel.setBounds (0, 0, 600, 25);
        Workout1.setBounds (20, 80, 100, 25);
        Workout2.setBounds (20, 100, 100, 25);
        jcomp4.setBounds (150, 75, 350, 350);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void setExercise(String option){

    }

    public void updateFrame(){
        parentUI.updateDisplay();
    }
}
