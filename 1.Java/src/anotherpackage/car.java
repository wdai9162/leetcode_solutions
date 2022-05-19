package anotherpackage;

public class car extends machine {

    public static String material; 

    public String brand; 
    public String name; 
    private int profit; 
    
    public car(String name, String brand, double price){
        this.material = "metal";
        this.brand = brand; 
        this.name = name; 
        setPrice(price);
        this.profit = 23; 
    }

    public void getName(){
        System.out.println(this.brand);
    }

    public void getProfit(){
        System.out.println(this.profit);
    }
    
}
