package src;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Exercise {
    
    private String type, name, description;
    private int reps, id;

    //Can be used for weight, time, distance, etc.
    private String extra1Name, extra2Name;
    private double extra1Val, extra2Val;

    //Image
    private BufferedImage image;
    private Image scaledImage;
    private String imageName;
    private static String imagePath = "src/data/images/";
    
    private static int currentid = 0;

    public Exercise(int ID, String type, String name, String imageName, String extra1Name, String extra2Name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.reps = 0;
        this.extra1Name = extra1Name;
        this.extra2Name = extra2Name;
        this.extra1Val = 0;
        this.extra2Val = 0;
        try{
            this.image = ImageIO.read(new File(imagePath + imageName));
            this.scaledImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
            //logoPic = new JLabel(new ImageIcon(scaledlogo));
            //add(logoPic, BorderLayout.CENTER);
        }catch (IOException e){
            System.out.print("Exercise: " + name + ": ");
            System.out.println("Error Reading Picture");
        }
        this.imageName = imageName;
        if (ID == -1) {
            this.id = currentid;
            currentid++;
        } else {
            this.id = ID;
            currentid = ID + 1;
        }
    }

    public Exercise(String type, String name, String imageName, String extra1Name, String extra2Name) {
        this(-1, type, name, imageName, extra1Name, extra2Name, null);
    }
    public Exercise(String type, String name, String imageName, String extra1Name ) {
        this(type, name, imageName, extra1Name, null);
    }
    public Exercise(String type, String name, String imageName) {
        this(type, name, imageName, null);
    }
    public Exercise(int id, String type, String name, String imageName) {
        this(type, name, imageName);
        this.id = id;
    }
    

    public String getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public Integer getReps() {
        return this.reps;
    }
    public Integer getID() {
        return Integer.valueOf(this.id);
    }
    public String getExtra1Name() {
        return this.extra1Name;
    }
    public String getExtra2Name() {
        return this.extra2Name;
    }
    public double getExtra1Val() {
        return this.extra1Val;
    }
    public double getExtra2Val() {
        return this.extra2Val;
    }
    public Image getScaledImage() {
        return this.scaledImage;
    }
    public String getImageName() {
        return this.imageName;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    public void setID(int id) {
        this.id = id;
    }
    public void setExtra1Name(String extra1Name) {
        this.extra1Name = extra1Name;
    }
    public void setExtra2Name(String extra2Name) {
        this.extra2Name = extra2Name;
    }
    public void setExtra1Val(double extra1Val) {
        this.extra1Val = extra1Val;
    }
    public void setExtra2Val(double extra2Val) {
        this.extra2Val = extra2Val;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

}
