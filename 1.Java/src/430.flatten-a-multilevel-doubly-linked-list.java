import solutionpackage.Node;

/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// import solutionpackage.*;

class Solution {
    public Node flatten(Node head) {
        
        if(head==null){
            return head; 
        }

        Node currNode = head;     //use currNode as a pointer 

        while(currNode != null){

            if(currNode.child!=null){
                insertChild(currNode);
            }
            currNode = currNode.next; 
        } 

        while(head.next!=null){
            if(head.next.prev != head){
                System.out.print(head.val);
                return head; 
            }
            head = head.next;
        }

        return head; 
    }


    private void insertChild(Node currNode){
        Node temp, tempHead;
        tempHead = currNode;         //store the original head 
        temp = currNode.next;        //store the original next 
        
        currNode.next = currNode.child;
        currNode.child.prev = currNode;   //doubly link the child 

        while(currNode.next != null){     //ignore the child level here for now (Needs to be OPTIMIZED with recursion)
            currNode = currNode.next; 
        }

        currNode.next = temp;             
        temp.prev = currNode;             //doubly link back to the parent level 
        
        currNode = tempHead; 
    }

}
// @lc code=end

