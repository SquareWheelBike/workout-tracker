package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

public class ExercisesUI extends JPanel implements ActionListener{

    private JComboBox<String> exersices;
    private JLabel selectLabel, message;
    private initUI parentUI;
    private Exercises list;

    public ExercisesUI(initUI parentUI) {
        this.parentUI = parentUI;

        setLayout(new BorderLayout());

        list = new Exercises();
        list.testExercises();

        //Create Label
        selectLabel = new JLabel("Please Select a Exersice:  ");
        add(selectLabel, BorderLayout.LINE_START);

        //Create Drop box
        exersices = new JComboBox<String>(list.getExersiseList().toArray(new String[0]));
        exersices.addActionListener(this);
        add(exersices, BorderLayout.LINE_END);
        //exersices.setBounds (250, 10, 300, 50);

        //Create message when user clicks
        message = new JLabel("Selected");

    }

    public void actionPerformed(ActionEvent e) {
        //String s = (String)exersices.getSelectedItem();
        System.out.print("ExercisesUI: "); 
        String s = (String)exersices.getSelectedItem();
        switch(s){
            case "Push Ups":
                System.out.println("Push Ups selected");
                break;
            case "Sit Ups":
                System.out.println("Sit Ups selected");
                break;
            case "Chin Ups":
                System.out.println("Chin Up selected");
                break;
            default:
                System.out.println("Unknown selected");
        }
        setExercise(s);
    }

    public void setExercise(String option){
        remove(message);
        message.setText(option + " Selected");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        add(message, BorderLayout.PAGE_END);
        updateFrame();
    }

    public void updateFrame(){
        parentUI.updateDisplay();
    }
}
