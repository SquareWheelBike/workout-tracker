package src;

import java.awt.*;

import javax.swing.*;

public class initUI extends JFrame{

    private JPanel mainArea, taskBar;
    private ManageExercise exercisesManager;
    private JPanel exerciseUI, taskBarUI, homePageUI, workoutPageUI, scheduleUI, settingsUI;
    private ManageUser userManager;
    private User curUser;

    /**
     * Create Startup Screen and all default parameters.
     * Load HomePageUI and TaskBarUI by default
     * Setup all other panels to be invisible, show appropriate panel when clicked
     * Each menu item has a corresponding panel to show with class
     */
    public initUI(){               
        initUserData();                 //initialize last user data and userlist
        initUIPages();                  //initialize all UI pages        
        initJFrame();                   //initialize JFrame Window
        initTaskBar();                  //initialize taskbar and displays homepage
        updateDisplay();                //update display
    }


    public void updateDisplay(){
        setVisible(true);
        revalidate();
        repaint();
    }

    public void closingEvent(){
        //save user data
        System.out.println("Save Last User: " + curUser.getName());

        userManager.saveLastUser(curUser.getName());
        userManager.saveUser();
        System.out.println("Program is Closing");
        System.exit(0);
    }

    /**
     * Checks if User information is available, if not, create new user
     * Waits till user is created till function returns
     */
    public void initUserData(){
        userManager = new ManageUser();
        //If no user data is found, create a new user
        if(userManager.loadUser() == false){
            userManager.createUserUI();
        }
        //FIXME: maybe a better way to do this
        //Halt program until user is created
        while(curUser == null){
            curUser = userManager.getUser(userManager.loadLastUser());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Current User: " + curUser);
    }

    public void initUIPages(){
        exercisesManager = new ManageExercise();
        exerciseUI = new ExercisesUI(this, exercisesManager);
        taskBarUI = new TaskBarUI(this);
        homePageUI = new HomePageUI(this, "Welcome Back " + curUser.getName() + "!");
        workoutPageUI = new WorkoutsUI(this, exercisesManager);
        scheduleUI = new ScheduleUI(this);
        settingsUI = new SettingsUI(this, curUser, userManager);

    }

    /**
     * Initialize and display the taskbar and homepage
     */
    public void initTaskBar(){
        //Setup main area default homepage
        mainArea = new JPanel();        
        mainArea.add(homePageUI);
        add(mainArea, BorderLayout.CENTER);

        //Setup Taskbar at bottom
        taskBar = new JPanel();
        taskBar.add(taskBarUI);
        add(taskBar, BorderLayout.SOUTH); 
    }
    
    /**
     * Setup JFrame Size, title, and close operation
     * Edit closingEvent() to change closing behavior
     */
    public void initJFrame(){
        setLayout(new BorderLayout());  //Set taskbar layout

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


}
