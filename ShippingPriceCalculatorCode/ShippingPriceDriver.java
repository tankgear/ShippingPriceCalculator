import java.util.Scanner;
import java.util.ArrayList;
/*
  ShippingPriceDriver.java
  @author Brett Kamen
  @version 1.0.0

  Shipping Price Calculator
  Welcome to you shipping calculator helper 
  It takes the weight of your product, the price of the product, and shipping option that you choose to calculate how much a person will pay for shipping
  With shipping not only is there a set price for shipping, but they also charge a fee for how much the object you are shipping ways
  In my example I chose that for every 1 lb your object weighs you pay an exta $0.75
*/
public class ShippingPriceDriver {
    public static void main(String[] args) {
        TotalPrice s = new TotalPrice();
        Scanner keyboard = new Scanner(System.in);
        ArrayList<ShoppingCart> cart = new ArrayList<ShoppingCart>();

        String name = "na";
        double price = 0.00; //in dollars
        double weight = 0.00; // lbs 
        String Option;
        double Standard = 2.00; //in dollars
        double Express = 5.00; //in dollars
        double totalPrice = 0; //in dollars
        double totalWeight = 0; 
        double totalWeightFee = 0; //in dollars
        double tax = 0.07; 
        double totalTax = 0;
        double weightFee = 0.75; //in dollars
        double totalTaxFee = 0; // in dollars
        
        
        while (!name.equalsIgnoreCase("Done")){

            System.out.println("Enter product name or Done");
            name = keyboard.nextLine();
        
            System.out.println("What is the price of the sculpture?");
            price = keyboard.nextDouble(); //in dollars

            System.out.println("What is the weight of the sculpture?");
            weight = keyboard.nextDouble(); //in lbs
            keyboard.nextLine();

            if(!name.equalsIgnoreCase("Done")){
                cart.add(new ShoppingCart(name, price, weight));
            }
        }
        /*in lines 35-48, this is a while loop where a user can input as many times as they want until they say done and each time a new input gets stored in an ArrayList
        this loop will continue even after you say done, but won't save the info to the ArrayList due to the if statement on line 47
        */

        int items = cart.size();
        System.out.println("You have this many items in your cart " + items);
        //in lines 55-56, shows the user on the console how many items are stored in the ArrayList will be an integer
        
        for(int i = 0; i < cart.size() ; i++){
        ShoppingCart inside = cart.get(i);
        totalPrice += Math.round(inside.getPrice() *100.0)/100.0;
        }
        //in lines 59-61 a for loop that retrieves the price of each input stored in the ArrayList and then uses a round function to get each price to be at 2 decimal places

        for(int i = 0; i < cart.size(); i++){
        ShoppingCart inside = cart.get(i);
        totalWeight += inside.getWeight();
        totalWeightFee = Math.round(totalWeight * weightFee * 100.0)/100.0;  
        }
        //in lines 65-68 a for loop that retrieves the weight of each input stored in the ArrayList and then uses a round function to get each weight to be at 2 decimal places

        for(int i = 0; i < cart.size(); i++){
        ShoppingCart inside = cart.get(i);
        totalTax += inside.getPrice(); 
        totalTaxFee = Math.round(totalTax * tax * 100.0)/100.0;
        }
        /*in lines 72-75 a for loop that retrieves the weight of each input stored in the ArrayList
        is then multiplied by 0.07 which is the tax and then rounded to 2 decimal places for what the overall tax is
        */

        System.out.println("Would you like to do standard or express shipping?");
        Option = keyboard.next(); 
        //in lines 81-82 asks the user on the console what type of shipping option they prefer

        for(int i = 0; i < cart.size(); i++){
        ShoppingCart inside = cart.get(i);
        System.out.println("The item you are purchasing is: " + inside.getName() + " and the cost is: $" + inside.getPrice());
        }
        //in lines 85-87 a for loop that retrieves the names and prices from the ArrayList to output on the console what the person inputed

        if(Option.equalsIgnoreCase("Standard") && totalPrice <= 65){
            double ShipFee = totalWeightFee + Standard;
            System.out.println("That comes out to: $" + totalPrice);
            System.out.println("The tax comes out to: $" + totalTaxFee);
            System.out.println("For shipping it costs: $" + ShipFee);
            s.setOverallcost(totalPrice + ShipFee + totalTaxFee);
            System.out.println(s);
        }
        //in lines 91-97, an if statement that when satndard is inputted and the price of products is less than or equal to $65 dollars it will output the following statements

        else if(Option.equalsIgnoreCase("Express") && totalPrice <= 65){
            double ShipFee = totalWeightFee + Express;
            System.out.println("That comes out to: $" + totalPrice);
            System.out.println("The tax comes out to: $" + totalTaxFee);
            System.out.println("For shipping it costs: $" + ShipFee);
            s.setOverallcost(totalPrice + ShipFee + totalTaxFee);
            System.out.println(s);
        }
        //in lines 101-107, an if statement that when express is inputted and the price of products is less than or equal to $65 dollars it will output the following statements

        else{
            System.out.println("That comes out to: $" + totalPrice);
            System.out.println("The tax comes out to: $" + totalTaxFee);
            System.out.println("Shipping is included with your purchase");
            s.setOverallcost(totalPrice + totalTaxFee);
            System.out.println(s);
        }
        /*in lines 111-116, an if statement that when either satndard or expressw is inputted but the price of products is greater than or equal to $65 dollars
        it will print the following statement but without a shipping fee cause it is included
        */ 

    }
}


