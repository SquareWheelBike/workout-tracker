package src;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
//import javax.swing.event.*;


public class WorkoutsUI extends JPanel implements ActionListener {
    private initUI parentUI;
    private ManageExercise exercisesManager;

//    private JRadioButton Workout1, Workout2;
//    private JLabel selectLabel;

    private ArrayList<JRadioButton> buttonsList;
    private JLabel selectLabel;
    private JTextArea jcomp4;

    private Map<String, ArrayList<Integer>> workoutsMap;
    private JPanel subPanel, exercisesPanel;; 
    private JComboBox<String> exersices;

    private GridBagConstraints c;
    private FormateGUI gui;


    private ArrayList<Exercise> listInWorkout;
    

    public WorkoutsUI(initUI parentUI, ManageExercise exercisesManager) {
        c = new GridBagConstraints();
        gui = new FormateGUI();

        this.parentUI = parentUI;
        this.exercisesManager = exercisesManager;
        this.workoutsMap = new HashMap<String, ArrayList<Integer>>();

        this.addDefaultWorkouts();

        selectLabel = new JLabel ("Please Select a Workout");
        add (selectLabel);

        ButtonGroup workouts = new ButtonGroup();
        buttonsList = new ArrayList<JRadioButton>();
        int count = 0;
        for(String names : workoutsMap.keySet()){
            buttonsList.add(new JRadioButton(names));
            workouts.add(buttonsList.get(count));
            buttonsList.get(count).setBounds (20, 80+(count*20), 100, 25);
            buttonsList.get(count).addActionListener(this);
            add(buttonsList.get(count));
            count++;

        }        

        //Workout1 = new JRadioButton ("Abs Burner");
        //Workout1.addActionListener(this);
        //add (Workout1);
        //Workout2 = new JRadioButton ("Fitness");
        //Workout2.addActionListener(this);
        //add (Workout2);

        subPanel = new JPanel();
        exercisesPanel = new JPanel();
        initSubPanel(subPanel, null);
        subPanel.setBounds (150, 75, 350, 350);
        
        subPanel.add(exercisesPanel, BorderLayout.CENTER);
        add(subPanel);
        //add (jcomp4);

        //adjust size and set layout
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);


        //set component bounds (only needed by Absolute Positioning)
        selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectLabel.setBounds (0, 0, 600, 25);
        //Workout1.setBounds (20, 80, 100, 25);
        //Workout2.setBounds (20, 100, 100, 25);
        //jcomp4.setBounds (150, 75, 350, 350);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.print("WorkoutUI: ");
        //System.out.println("Action Event: " + e.getSource());
        if(e.getSource() instanceof JRadioButton){
            JRadioButton button = (JRadioButton) e.getSource();
            remove(subPanel);
            System.out.println(button.getText());
            initSubPanel(subPanel, button.getText());
            add(subPanel);
            updateFrame();
        }
        else if(e.getSource() instanceof JComboBox){
            JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
            String exerciseName = comboBox.getSelectedItem().toString();
            System.out.println(exerciseName);
            for(Exercise o: listInWorkout){
                
                if(o.getName().equals(exerciseName)){
                    System.out.println("Found: " + o.getName());
                    subPanel.remove(exercisesPanel);
                    displayExercise(o);
                    subPanel.add(exercisesPanel,BorderLayout.CENTER);
                    subPanel.revalidate();
                    subPanel.repaint();
                    updateFrame();
                    break;
                }
            }
        }
        else{
            System.out.println("Unknown: " + e.getSource());
        }
    }

    public void setExercise(String option){

    }

    public void addDefaultWorkouts(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(20);
        workoutsMap.put("Abs Burner", list);
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        workoutsMap.put("Leg Day", list);
    }

    public void updateFrame(){
        parentUI.updateDisplay();
    }

    /**
     * displays a drop down menu of the types of exercises and displays the exercises for the selected
     */
    public void initSubPanel(JPanel subPanel, String workoutName){
        

        subPanel.setLayout(new BorderLayout(0, 0));
        subPanel.removeAll();
        //subPanel.setBackground(Color.white);

        exersices = new JComboBox<String>();
        
        if(workoutName != null){            
            listInWorkout = new ArrayList<>();
            //add exercises to JcomboBox from workoutMap with id
            for(int id : workoutsMap.get(workoutName)){
                listInWorkout.add(exercisesManager.getExerciseByID(id));
                exersices.addItem(exercisesManager.getExerciseByID(id).getName());
            }
            exersices.addActionListener(this);

            subPanel.add(exersices, BorderLayout.NORTH);
        }
        
        subPanel.setVisible(true);
        subPanel.revalidate();
        subPanel.repaint();
        
    }

    public void displayExercise(Exercise exercise){
        //display exercise
        FormateGUI gui = new FormateGUI();
        GridBagConstraints c = new GridBagConstraints();
        
        //Add exercise name
        exercisesPanel = new JPanel();
        exercisesPanel.setLayout(new GridLayout(10,10));
        
        //Add padding
        gui.setGrid(c, 0, 0, 100);
        exercisesPanel.add(new JLabel("PENIS"), c);  

        c = gui.setGrid(c, 0, 1);
        exercisesPanel.add(new JLabel(exercise.getName(),  SwingConstants.CENTER), c);
        
        
        c = gui.setGrid(c, 0, 2, 300);
        JLabel exercisePic = new JLabel(new ImageIcon(exercise.getScaledImage()));
        exercisesPanel.add(exercisePic, c);

        

    


        //TODO: display image of exercise
        //c = gui.setGrid(c, 1, 2);
        //exercisPanel.add(new JLabel (exercise.getImage()),c);

        c = gui.setGrid(c, 0, 3);
        exercisesPanel.add(new JLabel ("Reps:"),c);
        c = gui.setGrid(c, 1, 3);
        exercisesPanel.add(new JTextArea(1,10),c);

        exercisesPanel.setVisible(true);
        exercisesPanel.revalidate();
        exercisesPanel.repaint();

    }
}
