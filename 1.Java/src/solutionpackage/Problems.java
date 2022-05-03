package solutionpackage;

public class Problems {
    
    /*
    -----
    We have an array of integers representing fishes swimming in an one lane river.
    The position of each fish in the array represents its current position in the river.
    For each fish, the absolute value from array represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
    Each fish moves at the same speed so only fishes swimming to different direction will meet.
    And if two fishes meet, the larger one will eat smaller one.
    Find out the number of surviving fishes after they reach either left end or right end.
    Note:
    1. fishes swimming at different direction won't have same size
    2. the size of fish will be a reasonable non-zero int value.

    Sample
    Input: fishes = [5,10,-6]
    Output: [5,10]

    Input: fishes = [10,2,-5,-11]
    Output: [-11]

    Input: fishes = [-10,2]
    Output: [-10,2]

    Input: fishes = [-2, 1, -2,-2]
    Output: [-2,-2,-2]

                | |
    [10,0,-11, 0,11,-12,34,-54]

        |       |
    [  0, 0, -11, 0, 11, -12, 0, -54]
        |        |
    [10,0,0,0,0,0,-13,-12]
    */ 

    public int[] findSurvivingFishes(int[] fishes) {
        
        int slow = 0;
        int fast = 1; 
        
        while(!checkState(fishes)){
        
            for (slow=0; slow < fishes.length-1; slow++) {
        
                while(fishes[slow]==0) {
                    slow++;
                }
                while(fishes[fast]==0) {
                    fast++; 
                }
        
                if (fishes[slow] > 0 && fishes[fast] < 0) {
                    if (fishes[slow]+fishes[fast] >= 0) {        //equal?
                    fishes[slow] = 0;
                    slow++;
                } else {
                    fishes[fast] = 0;
                    fast++;
                }
            } else {
                slow ++; 
                fast ++; 
            } 
        } 
            
        }
        
        return fishes; 
        
    }

    public boolean checkState (int[] fishes) {
            
            boolean signChange = false; 
            
            for (int i =0; i< fishes.length; i++) {
                if (fishes[0] >= 0 && fishes[i] <=0) {
                    
                    return false;
                    
                } else if (fishes[i] * fishes[i+1] <= 0) {
                    
                    if (signChange == false) {
                        signChange = true;    
                    } else {
                        return false; 
                    }
                }
            }
            
            return true;
        }

}
