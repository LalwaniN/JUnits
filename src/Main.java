
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Neha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Inventory inventory = new Inventory();
        
        Scanner sc = new Scanner (System.in);
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(4);
        array.add(7);
        
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(2);
        array2.add(4);
        array2.add(8);
        
        ArrayList<Integer> array3 = new ArrayList<>();
        array3.add(3);
        array3.add(3);
        
        inventory.addGoods("Red",array );
        inventory.addGoods("Green",array2 );
        inventory.addGoods("Yellow",array3 );
        
        inventory.checkIfOrderPossible("Red",10);
        inventory.checkIfOrderPossible("Green",10);
        inventory.printInventory();
        
        
        
        
        
        
    }
    
}
