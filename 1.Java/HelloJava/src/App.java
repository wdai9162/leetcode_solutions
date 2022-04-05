import testpackage.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import solutionpackage.Solutions;
import solutionpackage.MyLinkedList;

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

        Solutions mySolution = new Solutions(); 
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

        // HashSet<Integer> hh = new HashSet<Integer>();

        // hh.add(1);
        // hh.add(2);
        // hh.add(3);
        // hh.add(300);
        // hh.add(301);
        // hh.remove(3);
        // hh.contains(2);

        // System.out.println(hh);
        // System.out.println(Arrays.toString(hh.toArray()));
        // System.out.println(hh.hashCode());
        // System.out.println(hh.isEmpty());

        // Iterator<Integer> it = hh.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
        // }

        int[] arr111 = {4,3,2,7,8,2,3,1};
        // System.out.print(mySolution.findDisappearedNumbers(arr111));
        

    

       
    }   
}
