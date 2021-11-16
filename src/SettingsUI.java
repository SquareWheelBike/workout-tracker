package src;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;


public class SettingsUI extends JPanel implements ActionListener {
    private initUI parentUI;

//    private JRadioButton Workout1, Workout2;
//    private JLabel selectLabel;

    private JButton editButton, changeButton, resetButton;
    private JPanel settingsPanel, editUserPanel;

    private JTextField userName, userAge, userWeight, userHeight;
    private JButton editUserSubmit, backButton;


    public SettingsUI(initUI parentUI) {
        this.parentUI = parentUI;

        showSettings();


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            remove(settingsPanel);
            showEditUser();
        }
        else if(e.getSource() == changeButton) {

        }
        else if(e.getSource() == resetButton) {

        }
    }

    public void setExercise(String option){

    }

    public void showSettings(){
        settingsPanel = new JPanel();
    
        //Edit User button
        editButton = new JButton ("Edit User");
        editButton.addActionListener(this);
        settingsPanel.add (editButton);
        editButton.setBounds (25, 35, 210, 55);

        //Change User Button
        changeButton = new JButton ("Change User");
        changeButton.addActionListener(this);
        settingsPanel.add (changeButton);
        changeButton.setBounds (25, 110, 210, 55);

        //Reset to Default Button
        resetButton = new JButton ("Reset To Default");
        resetButton.addActionListener(this);
        settingsPanel.add (resetButton);
        resetButton.setBounds (25, 190, 210, 60);

        add(settingsPanel);

        this.updateFrame();
    }
    

    public void showEditUser(){
        //GridLayout layoutGrid = new GridLayout(0,10);

        editUserPanel = new JPanel();

        //editUserPanel.setLayout(new BoxLayout(editUserPanel, BoxLayout.Y_AXIS));
        editUserPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Back Button
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        c = setGrid(c, 0, 0);
        editUserPanel.add(backButton, c);

        //Add padding
        setGrid(c, 1, 1, 40);
        editUserPanel.add(new JLabel(""), c);

        //User Name        
        c = setGrid(c, 1, 2);
        editUserPanel.add(new JLabel("Name: "), c);
        userName = new JTextField (20);
        userName.addActionListener(this);
        c = setGrid(c, 2, 2);
        editUserPanel.add(userName, c);

        //Age
        c = setGrid(c, 1, 3);
        editUserPanel.add(new JLabel("Age: "), c);
        userAge = new JTextField (5);
        userAge.addActionListener(this);
        c = setGrid(c, 2, 3);
        editUserPanel.add(userAge, c);

        //Height
        c = setGrid(c, 1, 4);
        editUserPanel.add(new JLabel("Height: "), c);
        userHeight = new JTextField (5);
        userHeight.addActionListener(this);
        c = setGrid(c, 2, 4);
        editUserPanel.add(userHeight, c);

        //Weight
        c = setGrid(c, 1, 5);
        editUserPanel.add(new JLabel("Weight: "), c);
        userWeight = new JTextField (5);
        userWeight.addActionListener(this);
        c = setGrid(c, 2, 5);
        editUserPanel.add(userWeight, c);

        //Add padding
        setGrid(c, 1, 6, 20);
        editUserPanel.add(new JLabel(""), c);

        //Submit Button
        editUserSubmit = new JButton ("Submit");
        editUserSubmit.addActionListener(this);
        c = setGrid(c, 2, 7);
        editUserPanel.add(editUserSubmit, c);

        add(editUserPanel);

        this.updateFrame();
    }

    private GridBagConstraints setGrid(GridBagConstraints c, int gridX, int gridY, int ipady){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = ipady;
        c.gridx = gridX;
        c.gridy = gridY;
        return c;
    }

    private GridBagConstraints setGrid(GridBagConstraints c, int gridX, int gridY){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;
        c.gridx = gridX;
        c.gridy = gridY;
        return c;
    }

    public void updateFrame(){
        parentUI.updateDisplay();
    }
}
