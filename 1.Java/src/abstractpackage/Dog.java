package abstractpackage;

public class Dog extends Animal {
    
    private String type; 
    private String name; 
    private String color; 

    public Dog(String name, String type, String color, int birth){
        this.type = type;
        this.name = name; 
        this.color = color; 
        this.birth = birth; 
    }

    public void getType(){
        System.out.println(this.type);
    }

    public  int howOld(int today){
        return today-this.birth;
    }

    public int howHeavy(){
        return this.weight; 
    }
}
