package solutionpackage;

import java.util.*;

public class MyHashSet {

    int maxKeySize = 1000000;
    int bucketListSize = 1000;
    List<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>(maxKeySize);
    
    public MyHashSet() {

        for (int i=0; i<1000; i++){
            this.bucketList.add(i,null);
        }
    }

    public void add(int key) {
        
        int keyIndex = key%1000; 

        if(bucketList.get(keyIndex)==null){

            bucketList.set(keyIndex, new ArrayList<Integer>());
            bucketList.get(keyIndex).add(key);

        } else {
            if (!bucketList.get(keyIndex).contains(key)){
                bucketList.get(keyIndex).add(key);
            }
        }
    }
    
    public void remove(int key) {
        
        int keyIndex = key%1000;

        if(bucketList.get(keyIndex)==null){

            return; 

        } else {
            if (bucketList.get(keyIndex).contains(key)){
                for (int i=0; i < bucketList.get(keyIndex).size(); i++ ){
                    if(bucketList.get(keyIndex).get(i) == key){
                        bucketList.get(keyIndex).remove(i);
                        return; 
                    }
                }
            } else {
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        
        int keyIndex = key%1000; 
        if(bucketList.get(keyIndex)==null){

            return false; 

        } else {
            if (!bucketList.get(keyIndex).contains(key)){
                return false; 
            } else {
                return true;
            }
        }

    }
}