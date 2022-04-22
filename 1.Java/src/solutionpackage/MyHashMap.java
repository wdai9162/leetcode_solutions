package solutionpackage;

import java.util.ArrayList;

public class MyHashMap {

    //hash = key%1000 
    int maxKeySize = 1000000;
    int maxBucketSize = 1000; 

    ArrayList<ArrayList<int[]>> hashTable = new ArrayList<ArrayList<int[]>>();

    public MyHashMap() {
        for (int i=0; i<maxBucketSize; i++) {
            hashTable.add(i, null);
        }
    }
    
    public void put(int key, int value) {
        
        int hashKey = key%1000;
        int[] keyValue = new int[2];
        keyValue[0]=key;
        keyValue[1]=value; 
        
        if(hashTable.get(hashKey) == null){
            hashTable.set(hashKey, new ArrayList<>());
            hashTable.get(hashKey).add(keyValue);
        } else{
            
            //if the bucket exist 
            ArrayList<int[]> bucket = hashTable.get(hashKey); 

            //look into the bucket for the matching key 
            for(int i=0; i < bucket.size(); i++){
                if (bucket.get(i)[0] == key){
                    bucket.set(i, keyValue);           //if key exist, replace the value 
                    return; 
                } 
            }
            bucket.add(keyValue);                     //if not in this bucket, append the keyValue pair
        }
    }
    
    public int get(int key) {

        int hashKey = key%1000;
        
        if(hashTable.get(hashKey) == null){
            return -1; 
        } else{
            ArrayList<int[]> bucket = hashTable.get(hashKey); 

            //look into the bucket for the matching key 
            for(int i=0; i < bucket.size(); i++){
                if (bucket.get(i)[0] == key){
                    return bucket.get(i)[1];           //if key exist, replace the value 
                } 
            }
            return -1;                     //if not, return -1
        }
    }
    
    public void remove(int key) {
        int hashKey = key%1000;
        
        if(hashTable.get(hashKey) == null){
            return; 
        } else{
            //if the bucket exist 
            ArrayList<int[]> bucket = hashTable.get(hashKey); 

            //look into the bucket for the matching key 
            for(int i=0; i < bucket.size(); i++){
                if (bucket.get(i)[0] == key){
                    bucket.remove(i);                 //if key exist, remove the element
                    return; 
                } 
            }
            return;                     //if not, do nothing and return 
        }
    }
}
