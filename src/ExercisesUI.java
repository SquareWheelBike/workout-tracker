package src;

//import java.awt.*;
import javax.swing.*;

public class ExercisesUI extends JPanel {
    private JComboBox<String> exersices;
    private JLabel selectLabel;

    public ExercisesUI() {
        Exercises list = new Exercises();

        //Create Label
        selectLabel = new JLabel("Please Select a Exersice:");
        add(selectLabel);

        //Create Drop box
        exersices = new JComboBox<>(list.getExersiseList().toArray(new String[0]));
        add(exersices);
        exersices.setBounds (250, 10, 300, 50);

    }
}
