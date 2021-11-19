package src;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private static  String imagePath = "src/data/images/";
    
    private static int currentid = 1;

    public Exercise(String type, String name, String description, int reps, String extra1Name, int extra1Val, String extra2Name, int extra2Val, String imageName) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.reps = reps;
        this.extra1Name = extra1Name;
        this.extra2Name = extra2Name;
        this.extra1Val = extra1Val;
        this.extra2Val = extra2Val;
        try{
            this.image = ImageIO.read(new File(imagePath + imageName));
            this.scaledImage = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            //logoPic = new JLabel(new ImageIcon(scaledlogo));
            //add(logoPic, BorderLayout.CENTER);
        }catch (IOException e){
            System.out.print("Exercise: " + name + ": ");
            System.out.println("Error Reading Picture");
        }
        this.imageName = imageName;
        id = ++currentid;
    }
    public Exercise(String type, String name, String extra1Name, int extra1Val, String extra2Name, int extra2Val, String imageName) {
        this(type, name, null, 0, extra1Name, extra1Val, extra2Name, extra2Val, imageName);
    }
    public Exercise(String type, String name, String extra1Name, int extra1Val, String imageName) {
        this(type, name, extra1Name, extra1Val, null, 0, imageName);
    }
    public Exercise(String type, String name, String imageName) {
        this(type, name, null, 0, imageName);
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

    public int getReps() {
        return this.reps;
    }

    public int getId() {
        return this.id;
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
    public void setId(int id) {
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
