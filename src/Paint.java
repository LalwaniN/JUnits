
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha
 */
public class Paint {
    
    String color;
    ArrayList<Integer> cans;
    
    public Paint(String color){
        this.color= color;
        cans=new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Integer> getCans() {
        return cans;
    }

    public void setCans(ArrayList<Integer> cans) {
        this.cans = cans;
    }

   
    

}
