package dvdpackage;

public class MyDvd {

    public static double buyPriace = 5.55; 

    public String name;
    public int releaseYear;
    public String director;
    public int discount; 
    private double price_;

    void setPrice(double price) {
        price_ = price;
    }

    void setDiscount(int discount){
        this.discount = discount;
    }
    

    public MyDvd(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
    }

    public static void printAll(){
        System.out.println("this is a static method");
    }

}