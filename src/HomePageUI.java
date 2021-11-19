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

    private initUI parentUI;
    private JLabel welcomeLabel, logoPic, creators;
    private String userName;
    private BufferedImage logoPicture;

    public HomePageUI(initUI parentUI, User user) {
        userName = "NULL";
        if(user != null) {
            userName = user.getName();
        }
        else{
            System.out.print("Current User is null");
        }
        setLayout(new BorderLayout(0,10));

        //construct components

        //Add picture
        //Source: https://cdn2.vectorstock.com/i/1000x1000/53/96/workout-logo-with-triangle-man-vector-4235396.jpg
        try{
            logoPicture = ImageIO.read(new File("src/Pictures/Logo.jpg"));
            Image scaledlogo = logoPicture.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            logoPic = new JLabel(new ImageIcon(scaledlogo));
            add(logoPic, BorderLayout.CENTER);
        }catch (IOException e){
            System.out.print("HomepageUI: ");
            System.out.println("Error Reading Picture");
        }

        welcomeLabel = new JLabel ("Welcome Back " + userName + "!",  SwingConstants.CENTER);
        add (welcomeLabel, BorderLayout.PAGE_START);

        creators =  new JLabel ("Created by: Liam, Cole, and Mathew", SwingConstants.CENTER);
        add (creators, BorderLayout.PAGE_END);
        
    }
}
