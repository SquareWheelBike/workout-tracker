package src;

import java.awt.*;
import javax.swing.*;

public class initUI extends JFrame{

    private JPanel mainArea, taskBar;
    private JPanel exerciseUI, taskBarUI, homePageUI, workoutPageUI, scheduleUI, settingsUI;
    private ManageUser userManger;
    private User curUser;

    /**
     * Create Startup Screen and all default parameters.
     * Load HomePageUI and TaskBarUI by default
     */
    public initUI(){
        userManger = new ManageUser();
        //If no user data is found, create a new user
        if(userManger.loadUser() == false || userManger.loadLastUser() == null){
            userManger.createUserUI();
        }
        //FIXME: maybe a better way to do this
        //Halt program until user is created
        while(curUser == null){
            curUser = userManger.getUser(userManger.loadLastUser());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.print("Current User: " + curUser);
        
        //Create all UI setions
        exerciseUI = new ExercisesUI(this);
        taskBarUI = new TaskBarUI(this);
        homePageUI = new HomePageUI(this, curUser);
        workoutPageUI = new WorkoutsUI(this);
        scheduleUI = new ScheduleUI(this);
        settingsUI = new SettingsUI(this, curUser);

        //Set taskbar layout
        setLayout(new BorderLayout()); 

        //Setup main area default homepage
        mainArea = new JPanel();        
        mainArea.add(homePageUI);
        add(mainArea, BorderLayout.CENTER);

        //Setup Taskbar at bottom
        taskBar = new JPanel();
        taskBar.add(taskBarUI);
        add(taskBar, BorderLayout.SOUTH); 

        //Set Jframe parameters
        setTitle("Workout");
        setResizable(false);
        setAlwaysOnTop(true);
        setSize(600, 600);
        
        //Add a listener when the window is closed
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                closingEvent();
            }
        });
        setVisible(true);
    }

    /**
     * 1 - Home Screen <p>
     * 2 - Exercise <p>
     * @param option int of which screen to choose
     */
    public void setMainArea(int option){ 
        mainArea.removeAll();
        switch(option){
            case 0:
                mainArea.add(homePageUI);
                break;
            case 1:
                mainArea.add(exerciseUI);
                break;
            case 2:
                mainArea.add(workoutPageUI);
                break;
            case 3:
                mainArea.add(scheduleUI);
                break;
            case 4:
                mainArea.add(settingsUI);
                break;
            default:
                System.out.println("Error: Invalid option");
        }
        setVisible(true);
        updateDisplay();
    } 

    public void updateDisplay(){
        setVisible(true);
        revalidate();
        repaint();
    }
    
    public JPanel getExerciseUI(){
        return this.exerciseUI;
    }

    public JPanel getTaskBarUI(){
        return this.taskBarUI;
    }

    public void closingEvent(){
        System.out.println("Save Last User: " + curUser.getName());
        //userManger.saveLastUser(curUser.getName());
        System.out.println("Program is Closing");
        System.exit(0);
    }
}
