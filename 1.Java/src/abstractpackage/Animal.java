package abstractpackage;

public abstract class Animal {

    protected String sex; 
    protected int weight; 
    protected int birth; 

    public void whatsThis(){
        System.out.println("This is an anmial!");
    }

    public abstract int howOld(int today); 
    public abstract int howHeavy();  
}
