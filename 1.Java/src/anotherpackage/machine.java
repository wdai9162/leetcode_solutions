package anotherpackage; 

abstract class machine {
    final static double FEET_TO_CM=30.48;
    final static double PI = 3.14;
    
    private double price; 
    private String manufacture; 

    public void setPrice(double price){
        this.price = price; 
    }

    public void setManu(String manu){
        this.manufacture = manu; 
    }

    public void getPrice(){
        System.out.println(this.price);
    }

    public void getManu(){
        System.out.println(this.manufacture);
    }

   

    
}