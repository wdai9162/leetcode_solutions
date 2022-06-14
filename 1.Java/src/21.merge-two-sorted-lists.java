/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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

import solutionpackage.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null) {return list2;}
        else if(list2==null) {return list1;}
        else if(list1==null && list2==null) {return null;}
        
        ListNode head;
        ListNode temp; 

        if(list1.val >= list2.val) {
            temp = head = new ListNode(list2.val); 
            list2 = list2.next; 
        } else {
            temp = head = new ListNode(list1.val);
            list1 = list1.next; 
        }

        while(list1!=null && list2!=null){

            if(list1.val >= list2.val) {
                temp.next = list2; 
                temp = temp.next;
                list2 = list2.next; 
            } else {
                temp.next = list1; 
                temp = temp.next;
                list1 = list1.next; 
            }
        }

        while(list1!=null){
            temp.next = list1;
            temp = temp.next; 
            list1 = list1.next; 
        }

        while(list2!=null){
            temp.next = list2;
            temp = temp.next; 
            list2 = list2.next; 
        }

        return head; 
    }
}
// @lc code=end

