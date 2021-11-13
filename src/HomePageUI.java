package src;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HomePageUI extends JPanel {
    
    private JLabel welcomeLabel, logoPic;
    private String userName;
    private BufferedImage logoPicture;

    public HomePageUI() {
        userName = "{Name Goes Here}";

        //construct components
        welcomeLabel = new JLabel ("Welcome Back " + userName + "!",  SwingConstants.CENTER);

        //Add picture
        //Source: https://cdn2.vectorstock.com/i/1000x1000/53/96/workout-logo-with-triangle-man-vector-4235396.jpg
        try{
            logoPicture = ImageIO.read(new File("src/Pictures/Logo.jpg"));
            logoPic = new JLabel(new ImageIcon(logoPicture));
            add(logoPic);
            logoPic.setBounds (100, 100, 100, 100);
        }catch (IOException e){
            System.out.print("HomepageUI: ");
            System.out.println("Error Reading Picture");
        }


        add (welcomeLabel);

        welcomeLabel.setBounds (0, 10, 600, 20);
    }
}
