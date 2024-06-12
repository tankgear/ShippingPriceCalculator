public class ShoppingCart{
    //class that is used to make the shopping cart object
    private String name;
    private double price;
    private double weight;
    //initialized variables that are set to private

    public ShoppingCart(String name, double price, double weight){
        this.name = name;
        this.price = price;
        this.weight = weight;
    
    }
    //constructor where values are passed into the variables
    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public double getWeight(){
        return weight;
    }
    //getters that return the value that was inputted for these variables
}
