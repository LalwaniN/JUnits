
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Neha
 */
public class Inventory {

    ArrayList<Paint> goods;
    Stack<Integer> stack = null;
    int stackSum = 0;

    public Inventory() {
        goods = new ArrayList<>();
    }

    public ArrayList<Paint> getGoods() {
        return goods;
    }

    public void setGoods(ArrayList<Paint> goods) {
        this.goods = goods;
    }

    //mehtod to add goods to the inventory
    public void addGoods(String color, ArrayList<Integer> cans) {
        Paint paint = new Paint(color);
        paint.setCans(cans);
        goods.add(paint);
    }

    
    //method to print inventory goods
    public void printInventory() {
        int size = goods.size();

        System.out.print("Current Inventory : {");

        for (Paint paint : goods) {
            size--;
            System.out.print(paint.getColor() + "=[");
            int cansListSize = paint.getCans().size();
            for (int num : paint.getCans()) {
                --cansListSize;
                System.out.print(num);
                if (cansListSize > 0) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (size > 0) {
                System.out.print(",");
            }
        }

        System.out.print("}\n");

    }

    // Method to check if order can be checked out or not
    public ArrayList<Integer> checkIfOrderPossible(String color, int order) {
        ArrayList<Integer> result = new ArrayList<>();
        if (order <= 0) {
            System.out.println("Invalid Input for order");
            return result;
        }
        try {
            stack = new Stack<>();
            stackSum = 0;
            Paint paintRequired = null;
            int x = 0;
            for (Paint paint : goods) {

                if (paint.getColor().equalsIgnoreCase(color)) {
                    paintRequired = paint;
                    break;
                }
                x++;
            }
            
            if (paintRequired==null){
                System.out.print("Invalid input for color");
                return result;
            }
            
            // calling helper method to check if target order can be obtained or not
            subset(paintRequired.getCans(), 0, paintRequired.getCans().size(), order);

            if (stackSum != order) {
                System.out.println("Not possible to fulfill an order of " + order + " liter(s) of " + paintRequired.getColor() + " paint with current inventory.");

            } else {

                ArrayList<Integer> removeCans = new ArrayList<>();

                System.out.print("Checked out the following cans to fulfill the order of " + order + " liter(s) of " + paintRequired.getColor() + " paint: [");
                while (!stack.isEmpty()) {
                    int num = stack.pop();
                    removeCans.add(num);
                    System.out.print(num);

                    if (!stack.isEmpty()) {
                        System.out.print(",");

                    }

                }
                System.out.println("]");
                //Calling remove method to remove checked out paint cans
                removeFromInventory(x, removeCans);
                result = removeCans;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    //Helper method for checking if target order can be obtained from inventry
    public void subset(ArrayList<Integer> data, int fromIndex, int endIndex, int target) {

        if (stackSum == target) {
            return;
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (stackSum + data.get(currentIndex) <= target) {
                stack.push(data.get(currentIndex));
                stackSum += data.get(currentIndex);
                if (stackSum == target) {
                    break;
                }

                subset(data, currentIndex + 1, endIndex, target);
                if (stackSum == target) {
                    break;
                }
                stackSum -= stack.pop();
            }
        }
    }

    //Removing elements from inventory
    private void removeFromInventory(int num, ArrayList<Integer> removeCans) {

        for (int i = 0; i < removeCans.size(); i++) {
            Iterator itr = goods.get(num).cans.iterator();
            while (itr.hasNext()) {
                int next = (Integer) itr.next();
                if (removeCans.get(i) == next) {
                    itr.remove();
                    break;
                }
            }
        }

    }
}
