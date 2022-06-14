/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import solutionpackage.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head, temp; 
        temp = head = new ListNode();              //use temp node like a array pointer to iterate through the Linked List 
        
        while(l1!=null && l2!=null){
            
            temp.next = new ListNode();            //create the next Node 
            
            if (temp.val+l1.val+l2.val >=10){      //if the sume of the current digit is greater than 10
                temp.val = (temp.val+l1.val+l2.val)%10;   //in case temp.val has the carried over 1  
                //carry over the additional 1 to the next node 
                temp.next.val = 1; 
            } else temp.val = temp.val + l1.val + l2.val;
               
            
            if (l1.next == null && l2.next == null && temp.next.val == 0){
                temp.next = null;   //if both linked lists finish, remove the next node to avoid additional 0 
                return head; 
            } else {
            
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;    
            }
        }
        
        
        while(l1!=null){
            
            temp.next = new ListNode();
            
            if(temp.val + l1.val >= 10){
                temp.val = (temp.val + l1.val)%10;    //in case temp.val has the carried over 1  
                //carry over the additional 1 to the next node 
                temp.next.val = 1; 
            } else temp.val = temp.val + l1.val;   
            
            if (l1.next == null && temp.next.val == 0) {
                temp.next = null;
                return head;
            } else {
                temp = temp.next;  
                l1 = l1.next;
            }
        }
        
        while(l2!=null){
            
            temp.next = new ListNode();
            
            if(temp.val + l2.val >= 10){
                temp.val = (temp.val + l2.val)%10;
                //carry over the additional 1 to the next node 
                temp.next.val = 1; 
            } else temp.val = temp.val + l2.val;   //in case temp.val has the carried over 1  
            
            if (l2.next == null && temp.next.val == 0) {
                temp.next = null;
                return head;
            } else {
                temp = temp.next;  
                l2 = l2.next;
            }
        }
        
        return head;
    }
}
// @lc code=end

