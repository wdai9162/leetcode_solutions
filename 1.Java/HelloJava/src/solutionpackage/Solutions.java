package solutionpackage;
import java.util.Arrays;

public class Solutions {

    //Max Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {

        int max1=0; 
        int currentMax=0;

        for (int i=0; i < nums.length; i++) {
        //for (i: nums)

            if(nums[i]==0){
                if (currentMax > max1){
                    max1=currentMax;
                }

                //max1 = Math.max(currentMax, max1)
                currentMax=0;
            }
            else if (nums[i] == 1){
                currentMax++; 
            }

            // else {
            //     currentMax++
            // }
        }

        if (currentMax > max1){
            max1=currentMax;
        }

        return max1;
        // max(max1,currentMax)
    }

    //Find Numbers with Even Number of Digits
    public int findNumbers(int[] nums) {
        
        int evenCount = 0;

        for (int a=0; a<nums.length; a++){ 

            String numString = String.valueOf(Math.abs(nums[a]));
            if(numString.length()%2==0){
                evenCount++;
            }
        }

        return evenCount;

    }

    //Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {

    for (int i=0; i < nums.length; i++) {

        nums[i] = nums[i]*nums[i];

    }

    Arrays.sort(nums);
    return nums;
    
}
    
    //Duplicate Zeros
    public int[] duplicateZeros(int[] arr) {
     
        for (int i=0; i < arr.length; i++){
            
            //int temp=0;                                      

            if (arr[i] == 0 && i < arr.length-1){              //no action required if the last element is 0

                int temp = 0;

                for (int j=i; j < arr.length-2; j++) {         //no need to shift digits at the last 2 of the array
                    

                    if (j==i) {
                        temp = arr[j+2];
                        arr[j+2] = arr[j+1];
                        // System.out.println(("1st loop temp = " + temp));
                    }
                    else {
                        // System.out.println(("following loops temp = " + temp));
                        int temp2 = arr[j+2]; 
                        arr[j+2] = temp;
                        temp = temp2;
                    }
                }
                i++;                                            //skip the next element because it's replaced with 0;
                arr[i] = 0; 
            }

        }
        
        return arr;

    }

    //Merge Sorted Array
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        //                              
        // int[] nums11 = {1,2,3,0,4,5};
        // int m = 3;      |  
        // int[] nums22 = {0,4,5};
        // int n = 3; 

        for (int i=n-1; i >= 0; i--) {                //both edge cases can be elimianted using a while loop with condition (m>0 && n>0)
            
            if (i==0 && m==0){                   //edge case 1
                nums1[m+i] = nums2[0];   
            } 
            else if (m==0 && i!=0){
                nums1[m+i] = nums2[i];           //edge case 2 
            }
            else if (nums2[i] > nums1[m-1]) {
                nums1[m+i] = nums2[i];
            } 
            else {
                nums1[m+i] = nums1[m-1];
                i++;
                m--;
            }
            
        }
        return nums1;

    }

    //Remove Element
    public int removeElement(int[] nums, int val) {
        
        //int[] nums33 = {0,1,2,2,3,0,4,2};
        //int val1 = 2; 

        //int[] nums33 = {1,2,2,2};
        // int val1 = 2; 
        
        int expectedNums = nums.length;

        //=========================
        // for (int i=0; i < expectedNums; i++) {

        //     if (nums[i] == val){
        //         nums[i] = nums[expectedNums-1];
        //         expectedNums--;
        //         i--;
        //     }    
        // }

        //==========================
        // int i=0;
        // while (i < expectedNums) {
        //     if (nums[i] == val && nums[expectedNums-1] != val){
        //         nums[i] =  nums[expectedNums-1];
        //         expectedNums--;
        //         i++;
        //     } else if (nums[i] == val && nums[expectedNums-1] == val) {    //avoid unecessary copy and recheck the same number
        //         expectedNums--;
        //     } 
        //     else i++;
        // }

        //==========================
        int i=0;
        while (i < expectedNums) {
            if (nums[i] == val){
                nums[i] =  nums[expectedNums-1];
                expectedNums--;
            } else i++;
        }

        return expectedNums;

    }
    
    //Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        
        //int[] nums34 = {0,0,0,1,1,1,2,3,3,4};

        int i = 1;  //fast pointer
        int j = 0;  //slow pointer 

        while (i<nums.length) {

            if (nums[j] != nums[i]) { //j out of range?
                nums[j+1] = nums[i];
                j++;
            }   else {
                i++;
            }   
        }
        return j+1;
    }

    //Check If N and Its Double Exist
    public boolean checkIfExist(int[] arr) {
        
        //O(n^2)    Hashset??? can do O(n)

        if (arr==null || arr.length==0){
            return false; 
        }

        //i != j 
        //0<=i, j<=arr.length
        //arr[i] == 2 * arr[j]
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                if (i!=j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;

    } 

    //Valid Mountain Array (very ugly code, improve it!)
    public boolean validMountainArray(int[] arr) {
        
        //arr.length >= 3 
        if(arr==null||arr.length<3){
            return false;
        }

        int peak;
        boolean peaked = false;
        boolean hiked = false;

        for (int i=0; i<arr.length-1; i++) {

           if(arr[i] == arr[i+1]) {
               return false;
            }
            else if (arr[i] > arr[i+1]) {

                peak = i;
                peaked = true;
                
                while (peak < arr.length-1){
                    if (arr[peak] <= arr[peak+1]){
                        return false;
                    }
                    peak++;
                }
                if (hiked) return true;
            } 
            else if (arr[i] < arr[i+1]) hiked = true;
        }
        
        if (peaked&&hiked) return true;
        else return false;

    }


    //Replace Elements with Greatest Element on Right Side
    public int[] replaceElements(int[] arr) {
        
        for (int i=1; i<arr.length; i++) {
            
            int largest=0;
            int largest_index=0;
            int gap=0;
            
            for (int j=i; j<arr.length;j++) {
                
                if (arr[j] > largest ){
                    largest=arr[j];
                    largest_index=j;
                }
                
            }
            if (largest_index != i){
                gap = largest_index - i;
                while(gap >= 0) {
                    arr[i-1] = largest;
                    i++;
                    gap--;
                }
            }
            arr[i-1] = largest;
        }
        arr[arr.length-1] = -1; 
        return arr;
    }


}
