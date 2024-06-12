public class TotalPrice {
    //Class used to create the total price object
    private double OverallCost;
    //initialized variable that is set to private

    public TotalPrice(){
        OverallCost = 0;
    }
    //constructor where value is passed into the variable 

    public void setOverallcost(double OverallCost){
        this.OverallCost = OverallCost;
    }
    //setter where the value is set and returns that for the variables

    public String toString(){
        return ("The overall cost of your order is " + OverallCost);
    }
    //converts the object into a string, allowing an integer to be combined with a string
}
