package src;

import java.awt.*;
import java.awt.event.*;
//import java.util.ArrayList;

import javax.swing.*;
//import javax.swing.event.*;

public class ExercisesUI extends JPanel implements ActionListener{

    private JComboBox<String> exersices, types;
    private JLabel selectExersice, selectType;
    private initUI parentUI;
    private ManageExercise exercisesList;
    private JPanel typesPanel, listPanel, detailsPanel;

    public ExercisesUI(initUI parentUI) {
        this.parentUI = parentUI;

        setLayout(new BorderLayout());

        //Gets exercises from the database
        exercisesList = new ManageExercise();

        //Creates the drop down menu for the Types
        showTypes();
    }

    /**
     * if the user clicks on a type, it will show the exercises for that type
     * if the user clicks on an exercise, it will show the details for that exercise
     */
    public void actionPerformed(ActionEvent e) {
        System.out.print("ExerciseUI: ");

        //If user selected a type
        if (e.getSource() == types) {
            System.out.println("Type Selected: " + types.getSelectedItem());
            //remove all panels
            
            //Check if details is already displaying
            if(detailsPanel != null){
                if(detailsPanel.isShowing()){
                    remove(detailsPanel);
                }
            }
            
            //Check if exercise list is already displaying
            if(listPanel != null){
                if(listPanel.isShowing()){
                    remove(listPanel);
                }
            }
            String s = (String) types.getSelectedItem();
            showExercises(s);
        }

        //If user selected a exercise from a type
        else if (e.getSource() == exersices) {
            System.out.println("Exercise Selected: " + exersices.getSelectedItem());
            String s = (String) exersices.getSelectedItem();
            //Display exercise details
            showExerciseDetails(s);
        }

        else{
            System.out.println("Not found Element: " + e.getSource() + " \n" + e.getActionCommand());
        }
        
    }

    /**
     * refreshes display to update GUI
     */
    public void updateFrame(){
        parentUI.updateDisplay();
    }

    /**
     * displays a drop down menu of the types of exercises
     */
    public void showTypes(){
        //Create new panel to format layout
        typesPanel = new JPanel();

        //Create Label for Type of Exercise
        selectType = new JLabel("Please Select a Type of Exersice:  ");
        typesPanel.add(selectType, BorderLayout.NORTH);
        
        //Create Drop box
        types = new JComboBox<String>(exercisesList.getTypeList().toArray(new String[0]));
        types.addActionListener(this);
        typesPanel.add(types, BorderLayout.NORTH);

        //Add panel to the ExercisesUI Panel
        add(typesPanel, BorderLayout.NORTH);
        updateFrame();

    }

    /**
     * displays a drop down menu of the exercises for a type
     * @param type the type of exercise to display
     */
    public void showExercises(String type){
        //Create new panel to format layout
        listPanel = new JPanel();

        //Create Label for Exercise
        selectExersice = new JLabel("Please Select a Exersice:  ");
        listPanel.add(selectExersice, BorderLayout.CENTER);

        //Create Drop box
        exersices = new JComboBox<String>(exercisesList.getExersicesFromType(type).toArray(new String[0]));
        exersices.addActionListener(this);
        listPanel.add(exersices);

        //Add panel to the ExercisesUI Panel
        add(listPanel, BorderLayout.CENTER);
        updateFrame();
    }

    public void showExerciseDetails(String exercise){
        if(detailsPanel != null){
            remove(detailsPanel);
        }
        //Create new panel to format layout
        detailsPanel = new JPanel();
        
        detailsPanel.add(new JLabel(String.format("Selected Exercise: %s", exercise)));

        //Add panel to the ExercisesUI Panel
        add(detailsPanel, BorderLayout.SOUTH);
        updateFrame();
    }
}
