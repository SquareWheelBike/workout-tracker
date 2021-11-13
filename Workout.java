
import src.initUI;


public class Workout {
    public static void main(String[] args){
        new initUI();
        while(true){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
