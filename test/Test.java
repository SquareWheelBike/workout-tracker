import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String name = "testname";
        Serial test = new Serial(name);
        

        // test serializing
        try{
            FileOutputStream fos = new FileOutputStream("test.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(test);
            oos.close();
            fos.close();
            System.out.println("Serialized data is saved in test.ser");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

        // test deserializing
        Serial test2 = null;
        try{
            FileInputStream fis = new FileInputStream("test.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            test2 = (Serial)ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialized data is saved in test2");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }
        catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        // ensure that the deserialized object is the same as the original
        if(test.equals(test2)){
            System.out.println("Deserialized object is the same as the original");
        }
        else{
            System.out.println("Deserialized object is not the same as the original");
        }

        System.exit(0);
    }
}
