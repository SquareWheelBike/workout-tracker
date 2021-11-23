package src;

//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
//import javax.swing.event.*;


public class SettingsUI extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L; // VERSION NUMBER, needed for serialization
    private initUI parentUI;
    private ManageUser userManager;

    //Main panel
    private JPanel settingsPanel, newUserPanel, infoPanel, changePanel;
    private JButton newUserButton, changeButton, resetButton;

    //sub panels
    private JTextField userName, userAge, userWeight, userHeight;
    private JButton backButton, submitUserButton, confirmButton;
    private JComboBox<String> userOptionsBox;

    private User curUser;

    public SettingsUI(initUI parentUI, User user, ManageUser userManager) {
        this.parentUI = parentUI;
        this.curUser = user;
        this.userManager = userManager;

        showSettings();

    }

    public void actionPerformed(ActionEvent e) {
        System.out.print("SettingsUI: ");
        if (e.getSource() == newUserButton) {
            System.out.println("New User Button");
            remove(settingsPanel);
            showNewUser();
        }
        else if(e.getSource() == changeButton) {
            System.out.println("Change Button");
            remove(settingsPanel);
            showChangeUser();
        }
        else if(e.getSource() == resetButton) {
            System.out.println("Reset Button");
            remove(settingsPanel);
            showReset();
        }
        else if(e.getSource() == backButton) {
            System.out.println("Back Button");
            removeAll();
            showSettings();
        }
        else if(e.getSource() == confirmButton) {
            System.out.println("Reseting....");
            reset();
            System.out.println("Reset Complete");
            parentUI.dispose();
            System.exit(0);
        }
        else if(e.getSource() == submitUserButton) {
            System.out.println("new User Submit");
            User user = new User(userName.getText(), Integer.parseInt(userAge.getText()), Double.parseDouble(userWeight.getText()), Double.parseDouble(userHeight.getText()));
            userManager.addUser(user);
            userManager.saveUser();
            userManager.saveLastUser(userName.getText());
            parentUI.dispose();
            new initUI();
        }

        //If user selected a exercise from a type
        else if (e.getSource() == userOptionsBox) {
            System.out.println("User Selected: " + userOptionsBox.getSelectedItem());
            String s = (String) userOptionsBox.getSelectedItem();
            userManager.saveUser();
            userManager.saveLastUser(s);
            parentUI.dispose();
            new initUI();
        }
    }
    public void reset(){
        File file = new File("src/data/lastUser.ser");
        file.delete();
        file = new File("src/data/users.ser");
        file.delete();
    }

    public void showReset(){


        JPanel resetPanel = new JPanel();
        resetPanel.setLayout(new BorderLayout());

        resetPanel.add(new JLabel("Are you sure you want to delete all information?"), BorderLayout.PAGE_START);

        confirmButton = new JButton("Yes");
        confirmButton.addActionListener(this);
        resetPanel.add(confirmButton, BorderLayout.WEST);

        backButton = new JButton("No");
        backButton.addActionListener(this);
        resetPanel.add(backButton, BorderLayout.EAST);

        resetPanel.setVisible(true);
        resetPanel.revalidate();
        resetPanel.repaint();

        add(resetPanel);
        updateFrame();
    }
    public void showSettings(){
        settingsPanel = new JPanel();
        //Change User Button
        changeButton = new JButton ("Change User");
        changeButton.addActionListener(this);
        settingsPanel.add (changeButton);
        changeButton.setBounds (25, 110, 210, 55);

        //Edit User button
        newUserButton = new JButton ("New User");
        newUserButton.addActionListener(this);
        settingsPanel.add (newUserButton);
        newUserButton.setBounds (25, 35, 210, 55);

        //Reset to Default Button
        resetButton = new JButton ("Reset To Default");
        resetButton.addActionListener(this);
        settingsPanel.add (resetButton);
        resetButton.setBounds (25, 190, 210, 60);

        add(settingsPanel);

        this.updateFrame();
    }
    public void showNewUser(){
        newUserPanel = new JPanel();

        newUserPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Back Button
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        c = setGrid(c, 0, 0);
        newUserPanel.add(backButton, c);
        //Add padding
        setGrid(c, 1, 1, 40);
        newUserPanel.add(new JLabel(""), c);

        setGrid(c, 2, 2, 40);
        newUserPanel.add(this.showUserInfo(curUser), c);

        //Submit Button
        submitUserButton = new JButton ("Submit");
        submitUserButton.addActionListener(this);
        c = setGrid(c, 2, 7);
        newUserPanel.add(submitUserButton, c);
    
        add(newUserPanel);
    
        this.updateFrame();
    }
    public void showChangeUser(){
        changePanel = new JPanel();
        changePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //Back Button
        backButton = new JButton ("Back");
        backButton.addActionListener(this);
        c = setGrid(c, 0, 0);
        changePanel.add(backButton, c);

        //Add padding
        setGrid(c, 1, 1, 20);
        changePanel.add(new JLabel(""), c);
        //Label
        JLabel userLabel = new JLabel("Select a User:");
        c = setGrid(c, 3, 2);
        changePanel.add(userLabel, c);

        //Create Drop box
        userOptionsBox = new JComboBox<String>(userManager.getNames().toArray(new String[0]));
        userOptionsBox.addActionListener(this);
        c = setGrid(c, 3, 3);
        changePanel.add(userOptionsBox, c);



        add(changePanel);
        updateFrame();
    }
    public JPanel showUserInfo(User user){
        infoPanel = new JPanel();

        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //User Name        
        c = setGrid(c, 1, 2);
        infoPanel.add(new JLabel("Name: "), c);
        userName = new JTextField (20);
        userName.addActionListener(this);
        c = setGrid(c, 2, 2);
        infoPanel.add(userName, c);
        

        //Age
        c = setGrid(c, 1, 3);
        infoPanel.add(new JLabel("Age: "), c);
        userAge = new JTextField (5);
        userAge.addActionListener(this);
        c = setGrid(c, 2, 3);
        infoPanel.add(userAge, c);

        //Height
        c = setGrid(c, 1, 4);
        infoPanel.add(new JLabel("Height: "), c);
        userHeight = new JTextField (5);
        userHeight.addActionListener(this);
        c = setGrid(c, 2, 4);
        infoPanel.add(userHeight, c);

        //Weight
        c = setGrid(c, 1, 5);
        infoPanel.add(new JLabel("Weight: "), c);
        userWeight = new JTextField (5);
        userWeight.addActionListener(this);
        c = setGrid(c, 2, 5);
        infoPanel.add(userWeight, c);

        return infoPanel;
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
