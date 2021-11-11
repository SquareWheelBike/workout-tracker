package GUI;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class LoginPage extends JPanel{
    private ArrayList<String> userList;
    private ArrayList<String> selectList;

    public LoginPage(){
        setPreferredSize (new Dimension (600, 600));
        setLayout (null);

        //Add users for testing
        testUsers();
        
        for(int i = 0; i < userList.size(); i++){
            selectList.add(userList[i])
            JRadioButton userList.toString = new JRadioButton();
        }
    }
    
    public void addUser(String user){
        userList.add(user);
    }
    public void removeUser(String user){
        userList.remove(user);
    }

    public void testUsers(){
        userList.add("Mathew");
        userList.add("Cole");
        userList.add("Leeum");
    }

}
