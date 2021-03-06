package solutionpackage;
import java.util.*;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;


public class MySolutions {

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

    // for (int i=0; i < nums.length; i++) {
    //     nums[i] = nums[i]*nums[i];
    // }
    // Arrays.sort(nums);
    // return nums;
    // The above solution is not ideal because Arrays.sort has a time complexity of O(nlog(n)). The below solves the issue without sorting at O(n) time with a cost of O(n) space. 

        int[] results = new int[nums.length];
            
        int writePointer=nums.length-1;
        int leftPointer=0; 
        int rightPointer=nums.length-1;
        
        while (writePointer >= 0){
            
            if (Math.abs(nums[leftPointer]) > Math.abs(nums[rightPointer])) {
            
                results[writePointer] = nums[leftPointer]*nums[leftPointer];
                
                leftPointer++;
                writePointer--;
                    
            } else {
                
                results[writePointer] = nums[rightPointer] * nums[rightPointer]; 
                
                rightPointer--;
                writePointer--;
                
            }
        }
        return results;
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

    //Move Zeroes
    public void moveZeroes(int[] nums) {
        
        int writePointer = 0;
        int zeroCount = 0; 
        
        
        for (int readPointer = 0; readPointer < nums.length; readPointer++) {
            
            if(nums[readPointer]!=0) {
                nums[writePointer] = nums[readPointer];
                
                writePointer++;
                continue;
            }
            
            zeroCount++;  
            
        }
        
        for (int i = nums.length-1; i >= nums.length - zeroCount; i--) {
            
            nums[i] = 0;
                
        }
        
    }

    //Sort Array By Parity
    public int[] sortArrayByParity(int[] nums) {
        
        int evenWritePointer = 0; 
        int oddWritePointer = nums.length-1; 
        
        int[] result = new int[nums.length];
        
        for (int readPointer=0; readPointer < nums.length; readPointer++) {
            
            if (nums[readPointer]%2==0) {
                
                result[evenWritePointer] = nums[readPointer];
                evenWritePointer++;
                    
            } else {
                result[oddWritePointer] = nums[readPointer];
                oddWritePointer--;
            }
        }
        return result;
    }

    //Height Checker
    public int heightChecker(int[] heights) {
        //sort to expectedp[]
        //find heights[i] != expected[i]
        
        int mismatchCount = 0; 
        
        if(heights.length == 0) {
            return 0; 
        }
        
        //int[] expected = heights;                    // <----- This is wrong, it simply assign a reference to the origianl array.

        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        
        for (int i=0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatchCount++; 
            }
        }
        return mismatchCount; 
        
    }

    //Third Maximum Number
    public int thirdMax(int[] nums) {
        
        Arrays.sort(nums);
        
        int length = nums.length; 
        int writePointer = 1; 
        
        for (int readPointer=1; readPointer < nums.length; readPointer++) {
            
            if (nums[readPointer] != nums[readPointer-1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
            else {
                length--;
            }
            
        }
        
        
        if (length < 3){
            return nums[length-1];
        } 
        
        return nums[length-3];
        
    
    }

    //Find All Numbers Disappeared in an Array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> results = new ArrayList<Integer>(); 
        HashSet<Integer> numHash = new HashSet<Integer>();
    
        for (int i=0; i < nums.length; i++){
            numHash.add(nums[i]);
        }
        
        for (int i=1; i <= nums.length; i++){
            if (!numHash.contains(i)){
                results.add(i);
            }
        }    
        return results;
    }

    //Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        
        if (nums.length == 0){
            return false;
        }

        Set<Integer> hashset = new HashSet<Integer>();

        for(int i: nums) {

            if (hashset.contains(i)) { 
                return true;
            } else {
                hashset.add(i);
            }
        }
        return false; 
    }

    //Single Number ---> bit manipulation???
    public int singleNumber(int[] nums) {
        
        HashSet<Integer> hashset = new HashSet<Integer>();

        for (int i: nums) {
            if (hashset.contains(i)){
                hashset.remove(i);
            } else {
                hashset.add(i);
            }
        }

        // for (int i: nums) {
        //     if (hashset.contains(i)){
        //         return i;
        //     } 
        // }

        Iterator<Integer> it = hashset.iterator();
        while(it.hasNext()){
            return it.next();
        }

        return 0; 
    }

    //Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> hashset = new HashSet<Integer>(); 
        
        HashSet<Integer> results = new HashSet<Integer>(); 
        
        for (int i: nums1) {
            hashset.add(i);
        }
        
        for (int j: nums2) {
            if (hashset.contains(j)){
                results.add(j);
            }
        }
        
        Iterator<Integer> it = results.iterator();
        int[] res = new int[results.size()]; 
        int i=0; 
        while(it.hasNext()){
            res[i] = it.next();
            i++;
        }
   
        return res;
        
    }

    //Happy Number
    public boolean isHappy(int n) {
        
        Stack<Integer> stack = new Stack<Integer>();
        Set<Integer> hashset = new HashSet<Integer>();
        hashset.add(n);
        int sum=0;

        while (n != 1) {
            while (n >= 1){

                int num = n%10; 
                // stack.push(num);
                sum += num * num;
                n = n/10;
            }
            
            n = sum; 
            
            // while(!stack.isEmpty()){
            //     n += stack.peek() * stack.peek();
            //     stack.pop();
            // }
            
            if (!hashset.contains(n)){
                hashset.add(n);
            } else {
                return false; 
            }

            sum = 0;

        }
        return true;
    }

    //Two Sum  
    public int[] twoSum(int[] nums, int target) {
        
        
        
        //brutle force 
        //int[] ans = new int[2];
        //Map<Integer,int[]> hashmap = new HashMap<Integer,int[]>();
        // for (int i=0; i<nums.length;i++){
        //     for (int j=i+1; j<nums.length;j++){
        //         int[] idx = {i,j};
        //         hashmap.put(nums[i]+nums[j],idx);
        //     }
        // }

        // if(hashmap.containsKey(target)){
        //     ans = hashmap.get(target);
        // }

        //a better way to reduce time complexity 
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for (int i=0; i<nums.length; i++){
            hashmap.put(nums[i],i);
        }

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if (hashmap.containsKey(complement) && hashmap.get(complement)!=i){
               int[] ans = {i, hashmap.get(complement)};
               return ans; 
            }
        }

        return null;  
    }

    //Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
        
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        if (charArrayS.length!=charArrayT.length){
            return false; 
        }

        Map<Character,Character> hashmap = new HashMap<Character,Character>();

        for (int i=0; i<charArrayS.length;i++){
            if(hashmap.containsKey(charArrayS[i])){
                if(hashmap.get(charArrayS[i]) != charArrayT[i]){
                    return false; 
                }
            } else if(hashmap.containsValue(charArrayT[i])){
                return false; 
            } 
            hashmap.put(charArrayS[i],charArrayT[i]);
        }
        return true;
    }

    //Minimum Index Sum of Two Lists
    public String[] findRestaurant(String[] list1, String[] list2) {

        
        List<String> answer = new ArrayList<String>();
        int leastSum = 2000;

        Map<String,Integer> hashmap = new HashMap<String,Integer>();

        for(int i=0; i<list1.length;i++){
            hashmap.putIfAbsent(list1[i], i);
        }

        for(int i=0; i<list2.length;i++){
            if(hashmap.containsKey(list2[i])){
                if( (hashmap.get(list2[i])+i) < leastSum) {
                    leastSum=hashmap.get(list2[i])+i;
                    answer.clear();
                    answer.add(list2[i]);
                } else if(hashmap.get(list2[i])+i == leastSum) {
                    answer.add(list2[i]);
                }
            }
        }

        String[] answerArray = new String[answer.size()];
        answerArray = answer.toArray(answerArray);

        return answerArray; 
    }

    //First Unique Character in a String
    public int firstUniqChar(String s) {

        Map<Character,Integer> hashmap = new HashMap<Character,Integer>();

        char[] stringArr = s.toCharArray(); 

        for(int i = 0; i < stringArr.length; i++){

            if(!hashmap.containsKey(stringArr[i])){
                hashmap.put(stringArr[i], 100000+i);
            } else {
                int newVal = hashmap.get(stringArr[i]) + 100000;
                hashmap.put(stringArr[i], newVal);
            }
        }

        for(int i = 0; i < stringArr.length; i++){
            if(hashmap.get(stringArr[i])/100000 == 1){
                return hashmap.get(stringArr[i])%100000;
            }
        }
        
        return -1;

    }

    //Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        List<Integer> ans = new ArrayList<>();

        for(int i: nums1){
            if(!hashmap.containsKey(i)){
                hashmap.put(i,1);
            } else{
                hashmap.put(i,hashmap.get(i)+1);
            }
        }

        for (int i: nums2){
            if(hashmap.containsKey(i) && hashmap.get(i) != 0 ){
                ans.add(i);
                hashmap.put(i,hashmap.get(i)-1);
            }
        }

        int[] ansArray = new int[ans.size()];
        for (int i=0; i < ansArray.length; i++){
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    //Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if(nums.length < 2 && k == 0) {
            return false; 
        }

        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        //   value   index 

        for (int i=0; i < nums.length; i++){
            if(!hashmap.containsKey(nums[i])){
                hashmap.put(nums[i],i);
            } else {
                if(Math.abs(i-hashmap.get(nums[i])) <= k){
                    return true; 
                }else {
                    hashmap.put(nums[i],i);                //if doesn't work, there is no point to further store the previous element. Store the current one and check the next pair.  i.e [1,0,1,1] k=1  
                }
            }
        }

        return false; 
    }

    //Max Consecutive Ones II
    // Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

    // Example 1:

    // Input: [1,0,1,1,0]
    // Output: 4
    // Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    //     After flipping, the maximum number of consecutive 1s is 4.
    // Note:

    // The input array will only contain 0 and 1.
    // The length of input array is a positive integer and will not exceed 10,000
    // Follow up: What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
    public int findMaxConsecutiveOnesII(int[] nums){

        if(nums==null){
            return 0;
        }

        int maxCounter = 0;
        boolean flip = false; 
        int slow,fast;

        //    |
        //  | 
        // [1,0,1,1,0]

        for (slow = 0; slow < nums.length; slow++){

            if(nums[slow] == 1) {
                fast = slow+1; 
       
                while (fast < nums.length){
                    System.out.println("   "+fast+"bbb"+(fast-slow)+flip+"bbb"+maxCounter);
                    if(nums[fast] == 1 && fast == nums.length-1&& ((fast-slow) > maxCounter)){ System.out.println("update"); maxCounter = fast-slow; flip = false; break;}       //<=====very UGLY!!!!
                    else if(nums[fast] == 1) fast ++; 
                    else if(!flip){ flip = true; fast++; }
                    else if(flip && ((fast-slow) > maxCounter)){ System.out.println("update"); maxCounter = fast-slow; flip = false; break;}
                    else {
                        flip = false;
                        break;
                    }
                }
            }
            System.out.println(slow);
        }
        return maxCounter; 
    }
    


    
}
