/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Neha
 */
public class InventoryTest {
    Inventory instance;
    public InventoryTest() {
         instance = new Inventory();
        
        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(1);
        array1.add(4);
        array1.add(7);
        
        ArrayList<Integer> array2 = new ArrayList<>();
        array2.add(2);
        array2.add(4);
        array2.add(8);
        
        ArrayList<Integer> array3 = new ArrayList<>();
        array3.add(3);
        array3.add(3);
        
        instance.addGoods("Red",array1 );
        instance.addGoods("Green",array2 );
        instance.addGoods("Yellow",array3 );
    }
    
      @Test
    public void testCheckIfOrderPossible1() {
        System.out.println("checkIfOrderPossible");
        String color = "Green";
        int order =  10;
        ArrayList<Integer> result =instance.checkIfOrderPossible(color,order);
        int expectedResult =2;
        // TODO review the generated test code and remove the default call to fail.
          assertEquals("Size of arraylist is not as expected",expectedResult, result.size());
          assertEquals("Element at position 0 is not as expected",new Integer(8), result.get(0));
          assertEquals("Element at position 1 is not as expected",new Integer(2), result.get(1));   
          instance.printInventory();
    }
    

      @Test
    public void testCheckIfOrderPossible2() {
        System.out.println("checkIfOrderPossible");
        String color = "Red";
        int order =  10;
        ArrayList<Integer> result =instance.checkIfOrderPossible(color,order);
        int expectedResult =0;
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("The result arraylist should be empty",expectedResult, result.size());
        instance.printInventory();
    }
    
    
    @Test
    public void testCheckIfOrderPossible3() {
        System.out.println("checkIfOrderPossible");
        ArrayList<Integer> result1 =instance.checkIfOrderPossible("Green",10);
        ArrayList<Integer> result2 =instance.checkIfOrderPossible("Green",10);
        assertEquals("The result1 arraylist should have size as 2",2, result1.size());
        assertEquals("The result2 arraylist should be empty",0, result2.size());
        instance.printInventory();
    }
    
    
    @Test
    public void testCheckIfOrderPossible4() {
        System.out.println("checkIfOrderPossible test 4");
        ArrayList<Integer> result1 =instance.checkIfOrderPossible("Yellow",5);
        ArrayList<Integer> result2 =instance.checkIfOrderPossible("Yellow",3);
        ArrayList<Integer> result3 =instance.checkIfOrderPossible("Yellow",3);
        ArrayList<Integer> result4 =instance.checkIfOrderPossible("Yellow",3);

        assertEquals("The result1 arraylist should be empty",0, result1.size());
        assertEquals("The result2 arraylist should have size as 1",1, result2.size());
        assertEquals("Element at position 0 is not as expected",new Integer(3), result2.get(0));  
        assertEquals("The result3 arraylist should have size as 1",1, result3.size());
        assertEquals("Element at position 0 is not as expected",new Integer(3), result3.get(0)); 
        assertEquals("The result4 arraylist should be empty",0, result4.size());
        instance.printInventory();
    }
  
    
    @Test
    public void testCheckIfOrderPossible5() {
        System.out.println("checkIfOrderPossible");
        ArrayList<Integer> result =instance.checkIfOrderPossible("Yellow",-1);
        assertEquals("The result arraylist should be empty",0, result.size());
    }
    
    
    @Test
    public void testCheckIfOrderPossible6() {
        System.out.println("checkIfOrderPossible");
        ArrayList<Integer> result =instance.checkIfOrderPossible("Blue",7);
        assertEquals("The result arraylist should be empty",0, result.size());
    }
    
    
    @Test
    public void testCheckIfOrderPossible7() {
        System.out.println("checkIfOrderPossible");
        ArrayList<Integer> result =instance.checkIfOrderPossible("red",12);
        assertEquals("The result arraylist should have size as 3",3, result.size());
        instance.printInventory();

    }
   
}
