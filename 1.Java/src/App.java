import dvdpackage.*;

import java.util.*;

import javax.swing.tree.TreeNode;

import solutionpackage.*;

import anotherpackage.car; 

public class App {
    public static void main(String[] args) throws Exception {

        MyDvd[] DvdCollection = new MyDvd[10];

        DvdCollection[0] = new MyDvd("Good Movie", 1991, "David Dai");
        MyDvd starWarsDVD = new MyDvd("Star Wars", 1977, "George Lucas");

        for (int i=0; i < DvdCollection.length; i++) {
            DvdCollection[i] = new MyDvd("Movie "+i, 1000+i, "David Dai");

            // System.out.println(DvdCollection.length);
        }

        //For each VALUE in the Array.
        for (MyDvd i: DvdCollection){
            //System.out.println(i.toString());
        }

        MySolutions mySolution = new MySolutions(); 

        int[] nums = {0,1,1,1,1,0,0};
        // System.out.println(mySolution.findMaxConsecutiveOnes(nums));

        int[] nums2 = {12,234,-342};
        //System.out.println(mySolution.findNumbers(nums2));


        int[] num3 = {-4,-1,0,3,10};
        // System.out.println(Arrays.toString(mySolution.sortedSquares(num3)));


        int[] arr = {0,1,3,4,0,5,2,1};
        // System.out.println(Arrays.toString(mySolution.duplicateZeros(arr)));

        int[] nums11 = {0,2,3,0,0,0};
        int[] nums22 = {0,4,5};
        int m = 3;
        int n = 3; 
        // System.out.print(Arrays.toString(mySolution.merge(nums11, m, nums22, n)));

        int[] nums33 = {1,3,2,2};
        int val1 = 2; 
        // System.out.print(mySolution.removeElement(nums33, val1));
        // System.out.print(Arrays.toString(nums33));
        
        int[] nums34 = {0,0,0};
        // System.out.print(mySolution.removeDuplicates(nums34));
        // System.out.print(Arrays.toString(nums34));

        int[] arr105 = {10,2,5,3};
        // System.out.print(mySolution.checkIfExist(arr105));
    
        int[] arr106 = {5,4,3,2,1,0};
        // System.out.print(mySolution.validMountainArray(arr106));

        int[] arr107 = {0};
        mySolution.moveZeroes(arr107);
        // System.out.print(Arrays.toString(arr107));

        int[] arr108 = {3,1,2,4};
        // System.out.print(Arrays.toString(mySolution.sortArrayByParity(arr108)));

        int[] arr109 = {1,1,4,2,1,3};
        //System.out.print(mySolution.heightChecker(arr109));

        int[] arr110 = {2,2,3,1};
        // System.out.print(mySolution.thirdMax(arr110));


        // List<ArrayList<Integer>> bucketlist = new ArrayList<ArrayList<Integer>>(100);

        // bucketlist.add(234);

        // bucketlist.add(0,new ArrayList<>());
        // System.out.println(bucketlist);


        // MyHashSet hashset = new MyHashSet();
        // hashset.add(1);
        // hashset.add(1234);
        // hashset.add(1234);
        // hashset.remove(1234);


        // MyHashMap hashmap = new MyHashMap(); 
        // hashmap.put(1,1);


        // int[] nums131 = {1,2,3,4};
        // System.out.println(mySolution.containsDuplicate(nums131));

        // String name = "David";
        // char[] charArray = name.toCharArray();
        // for (char letter: charArray) {
        //     System.out.println(letter);
        // }

        // char[] reversed = new char[5]; 
        // int j = 0; 

        // for (int i=charArray.length-1; i>=0; i--) {
        //     reversed[j] = charArray[i];
        //     j++;
        // }

        // System.out.println(reversed);


        // int[] num333 = {4,9,5};
        // int[] num666 = {9,4,9,8,4};

        // mySolution.intersection(num333, num666);

        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1);
        // list1.add(1);
        
        // ArrayList<Integer> list2 = new ArrayList<>(); 
        // list2.add(2);
        // list2.add(2);

        // list1.addAll(list2);    
        // System.out.println(list1.toString());
        
        // solutionpackage.TreeNode node4 = new solutionpackage.TreeNode(2);
        // solutionpackage.TreeNode node3 = new solutionpackage.TreeNode(3);
        // solutionpackage.TreeNode node2 = new solutionpackage.TreeNode(2, node3, node4);
        // solutionpackage.TreeNode node1 = new solutionpackage.TreeNode(1,null,node2);

        // System.out.println(node1.postorderTraversal(node1));
        
        // //  1
        // //   2
        // //  3 4
        
        // System.out.println(node1.levelOrder(node1));
        
        // System.out.println(node1.maximum_depth_bottomup(node1));


        // mySolution.isHappy(18);


        // String a = "$5,252.50";
        // Double b = Double.parseDouble( a.replace("$",""));
        // Double discount = b*0.85; 
        // System.out.printf( "%.3f", discount);

        // findAPI findAPI = new findAPI();
        // // findAPI.createMyFile("C:/Users/wdai9/Desktop/", "javaFile.txt");
        // // findAPI.getFileGreaterThan("C:/Users/wdai9/OneDrive/Documents", 5);

        // // findAPI.findFileType("C:/Users/wdai9/OneDrive/Documents", "png");

        // findAPI.findModifiedXdays("C:/Users/wdai9/", 2);


        // MyDvd dvd1 = new MyDvd("dvd1", 1999, "abc");

        // System.out.println(dvd1.buyPriace);
        // dvd1.buyPriace = 100000; 

        // MyDvd dvd2 = new MyDvd("dvd2", 1998, "abc");
    
        // System.out.println(dvd2.buyPriace);

        // MyDvd.printAll();

        // car car1 = new car("david", "volvo", 23.3333); 
        
        // car1.setManu("China");
        // car1.getPrice();
        // car1.getManu();
        // car1.getPrice();

        // LinkedList<String> cars = new LinkedList<String>();

        // cars.add("volvo");
        // cars.add("bmw");
        // cars.add(1,"benz");
        // System.out.println(cars.indexOf("bmw"));

        // Iterator<String> it = cars.iterator(); 
        // while (it.hasNext()){
        //     System.out.println(it.next());
        // } 

     
        // HashMap<Integer,String> hashmap = new HashMap<Integer,String>();

        // hashmap.put(5,"Australia");
        // hashmap.put(10, "USD");

        // hashmap.containsKey(5);
        // hashmap.get(5);
        
        // for (int i: hashmap.keySet()){
        //     System.out.println(i);
        // }

        // for (String i: hashmap.values()){
        //     System.out.println(i);
        // }

        
        int[] nums66 = {1,0,1,1,0,1,1,1,1,1,1};
        System.out.println(mySolution.findMaxConsecutiveOnesII(nums66));

    }   
}












