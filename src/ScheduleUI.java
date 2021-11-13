package src;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;


public class ScheduleUI extends JPanel implements ActionListener {
    private initUI parentUI;

//    private JRadioButton Workout1, Workout2;
//    private JLabel selectLabel;

    private JRadioButton Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
    private JLabel selectLabel;
    private JTextArea jcomp4;

    public ScheduleUI(initUI parentUI) {
        this.parentUI = parentUI;

        selectLabel = new JLabel ("Please Select a Day");
        add (selectLabel);

        Sunday = new JRadioButton ("Sunday");
        Sunday.addActionListener(this);
        add(Sunday);
        Monday = new JRadioButton ("Monday");
        Monday.addActionListener(this);
        add(Monday);
        Tuesday = new JRadioButton ("Tuesday");
        Tuesday.addActionListener(this);
        add(Tuesday);
        Wednesday = new JRadioButton ("Wednesday");
        Wednesday.addActionListener(this);
        add(Wednesday);
        Thursday = new JRadioButton ("Thursday");
        Thursday.addActionListener(this);
        add(Thursday);
        Friday = new JRadioButton ("Friday");
        Friday.addActionListener(this);
        add(Friday);
        Saturday = new JRadioButton ("Saturday");
        Saturday.addActionListener(this);
        add(Saturday);

        jcomp4 = new JTextArea (5, 5);
        add (jcomp4);

        //adjust size and set layout
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);

        //Add to group to only allow 1 selected
        ButtonGroup group = new ButtonGroup();
        group.add(Sunday);
        group.add(Monday);
        group.add(Tuesday);
        group.add(Wednesday);
        group.add(Thursday);
        group.add(Friday);
        group.add(Saturday);


        //set component bounds (only needed by Absolute Positioning)
        selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectLabel.setBounds (0, 0, 600, 25);
        Sunday.setBounds (20, 100, 100, 25);
        Monday.setBounds (20, 120, 100, 25);
        Tuesday.setBounds (20, 140, 100, 25);
        Wednesday.setBounds (20, 160, 100, 25);
        Thursday.setBounds (20, 180, 100, 25);
        Friday.setBounds (20, 200, 100, 25);
        Saturday.setBounds (20, 220, 100, 25);        
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
