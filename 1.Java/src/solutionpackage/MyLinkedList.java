package solutionpackage;

import java.util.HashSet;
import java.util.spi.CurrencyNameProvider;

import javax.naming.NamingException;

import java.util.HashSet;

//Design Linked List / Linked List Cycle
public class MyLinkedList {

    Node head;
    int size = 0;

    class Node {
        int data; 
        Node next; 
        //Constructor 
        Node(int d) {
            data = d; 
        }
    }

    public MyLinkedList() {
        
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        } 
        else {
            Node curNode = this.head;
            while (index > 0) {
                curNode = curNode.next;
                index--; 
            }
            return curNode.data;
        }
    }
    
    public void addAtHead(int val) {
        
        if (this.head != null){
            Node curNode = new Node(val);
            curNode.next = this.head;
            this.head = curNode;
        } else {
            this.head = new Node(val);
        }
        size++;
    }

    public Node getHead(){
        return this.head;
    }

    public void addAtTail(int val) {

        if (this.head != null) {
            Node curNode = this.head;
            Node newTail = new Node(val);

            for (int i=0; i < size-1; i++){
                curNode = curNode.next;
            }

            curNode.next = newTail;
            size++;
        } 
        else {
            addAtHead(val);
        } 
    }
    
    public void setTailNext(Node node){

        Node curNode = this.head;

        for (int i=0; i < size-1; i++){
            curNode = curNode.next;
        }

        curNode.next = node;
    }

    public void addAtIndex(int index, int val) {   

        if (this.head != null && index > 0 && index <= size) {
            
            Node curNode = this.head;
            Node newNode = new Node(val);
            Node nextNode;

            while (index > 1) {
                curNode = curNode.next;
                index--; 
            }
            
            nextNode = curNode.next;
            curNode.next = newNode;
            newNode.next = nextNode; 
            size++;


        } else if (index == 0) {
            addAtHead(val);
        } 

    }
    
    public void deleteAtIndex(int index) {

        if (this.head != null && index > 0 && index < size) {
            
            Node curNode = this.head;
            Node nextNode;
            Node delNode;

            while (index > 1) {
                curNode = curNode.next;
                index--; 
            }
            
            delNode = curNode.next;
            nextNode = delNode.next;
            curNode.next = nextNode;
            size--;
        } 
        else if (index == 0 ) {
            this.head = head.next; 
            size--;
        } 
        
    }

    public int getSize() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < this.size; i++ ){
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }

    public void printMore(int number) {

        if (head==null){
            return;
        }

        Node curNode = head; 

        for (int i=0; i < number; i++){
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    //Linked List Cycle
    public boolean hasCycle() {
        
        //Brutle force uses hashset，check element 1 by 1，space complexity = O(n)
        // HashSet<Node> nodeSeen = new HashSet<Node>();
        // Node curNode; 

        // if (head != null && head.next != null){
        //     curNode=head; 
        // } else { return false; }

        // while ( curNode != null ) {

        //     if (nodeSeen.contains(curNode)){
        //         return true;
        //     } else {
        //         nodeSeen.add(curNode);
        //         curNode=curNode.next;
        //     }

        // }
        // return false;
        ////////////////////////////////////////////////////////////////////////////

        //two pointers solution，space complexity = O(1)
        if (head == null || head.next == null) {
            return false; 
        } 
        boolean loopControl = true;
        Node slow = head; 
        Node fast = head; 
        
        while(slow != fast || loopControl == true) {
            
            if (fast == null || fast.next == null ) {  //need to check fast and fast.next in order，the sequence matters，otherwise if fast itslef is null fast.next will throw an error
                return false; 
            }

            slow = slow.next;
            fast = fast.next.next;
            loopControl = false;
        }
        return true;
    }

    //Linked List Cycle II
    public Node findIntersection() {
            
        if (head == null || head.next == null) {
        return null; 
        } 

        boolean loopControl = true;
        Node slow = head; 
        Node fast = head; 
    
        while(slow != fast || loopControl == true) {
        
            if (fast == null || fast.next == null ) { 
            return null; 
            }

            slow = slow.next;
            fast = fast.next.next;
            loopControl = false;
        }
        return slow;
    }

    //Linked List Cycle II
    public Node detectCycle(Node head) {

        //two pointers solution，space complexity = O(1)
        //Step 1: find slow and fast intersection as in Linked List Cycle
        //Step 2: (head to startLoop = intersection to startLoop), therefore move head and intersection 1 step at a time until they meet 
        HashSet<Node> nodeHash = new HashSet<Node>(); 
        
        if (head == null || head.next == null) {
            return null;
        }

        Node curNode = head; 
        Node intersection = findIntersection();
        

        while (curNode != intersection) {

            if (intersection == null || intersection.next == null) { 
                return null; 
            }
            curNode = curNode.next;
            intersection = intersection.next;
        }

        return curNode;
    }

    //Intersection of Two Linked Lists
    public Node getIntersectionNode(Node headA, Node headB) {
        
        //time complexity = O(m+n)
        //space complexity = O(max(m,n))

        // if (headA == null || headB == null) {
        //     return null;
        // }
        
        // HashSet<Node> nodeHash = new HashSet<Node>(); 
        
        // while (headA != null){
            
        //     nodeHash.add(headA);
        //     headA = headA.next;
            
        // }
        
        // while (headB != null){
        //     if (nodeHash.contains(headB)) {
        //         return headB;
        //     }
        //     headB = headB.next; 
        // }

        //////////////////////////////////////////////////////////
        //space complexity = O(1) solution, append each list to each other so that after 1 complete loop, both queues start together at the same place. 

        if (headA == null || headB == null) {
            return null;
        }

        Node a_pointer = headA; 
        Node b_pointer = headB; 

        while (a_pointer != b_pointer){

            if (a_pointer == null){
                a_pointer = headB; 
            } else {
                a_pointer = a_pointer.next;
            }

            if (b_pointer == null){
                b_pointer = headA; 
            } else {
                b_pointer = b_pointer.next;
            }
        }

        //if both end at Null, means no intersection 
        if (a_pointer == null && b_pointer == null){
            return null;
        }


        return a_pointer;   
    }
    
    //Remove Nth Node From End of List
    public Node removeNthFromEnd(Node head, int n) {
        
        Node slowPointer = null;
        Node fastPointer = null; 
        
        if (head != null){
             slowPointer = head;
             fastPointer = head; 
        }
        
        //move fastPointer forward N steps. So when it reached the end, .next=null, the slowPointer arrives and the Nth last. 
        for (int i=0; i < n; i++){
            fastPointer = fastPointer.next;
        }
        
        while ( fastPointer != null && fastPointer.next != null) {
            
            fastPointer = fastPointer.next; 
            slowPointer = slowPointer.next; 
            
        }
        
        if ( fastPointer == null) {
            head = head.next; 
        } else {
            slowPointer.next = slowPointer.next.next;
        }
        
        return head;
        
    }

    //Reverse Linked List
    public Node reverseList(Node head) {

        if (head==null || head.next==null){
            return head; 
        } 
        
        Node curNode = head.next; 
        head.next = null;        //第一个head原本是指向第二个element的，如果不null那么当它成为tail以后就会有一个loop
        

        while(curNode != null) {
            Node nxtNode = curNode.next;
            curNode.next = head; 
            head = curNode;
            curNode = nxtNode; 
        }

        this.head = head;
        return head;
    }

    //Remove Linked List Elements
    public Node removeElements(Node head, int val) {
        
        Node fastPointer = null;
        Node slowPointer = null; 
        
        if (head != null) {
            
            while (head != null && head.data == val ) {
                head = head.next; 
            }
            
             if (head == null) {
                 return null; 
             }
            
            slowPointer = head; 
            fastPointer = head.next; 
        }  else {
            return null; 
        }
        
        
        while (fastPointer != null) {
            
            if (fastPointer.data == val){
            
                slowPointer.next = fastPointer.next;
                fastPointer = fastPointer.next; 
            
            } else {
                
                slowPointer = slowPointer.next; 
                fastPointer = fastPointer.next; 
                
            }
            
            
        }
        
        return head; 

        
    }


    //Palindrome Linked List ---- NOT working !
    public boolean isPalindrome(Node head) {
        
        // 3 Steps: 
        //findMiddle()
        //reverseListHalf()
        //compare the first hald and the second half

        Node middle = findMiddle(head);
        Node newMiddle = reverseListHalf(middle);

        Node slow = head; 
        Node fast = newMiddle;
        
        while (slow != newMiddle) {
           
            if (slow.data != fast.data) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }


    //Palindrome Linked List  
    public Node findMiddle(Node head) {
        
        if(head==null || head.next==null) {
            return head; 
        }

        Node slow = head; 
        Node fast = head.next; 
        
        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next; 

        }
        return slow; 
    }

    //Palindrome Linked List - reverse list from the middle node
    public Node reverseListHalf(Node middle) {

        if (middle==null || middle.next==null){
            return middle; 
        } 
        
        Node curNode = middle.next; 
        Node originMiddle = middle;    //储存原有的middle，完成时重新连接
        middle.next = null;            //第一个head原本是指向第二个element的，如果不null那么当它成为tail以后就会有一个loop
        
        while(curNode != null) {
            Node nxtNode = curNode.next;
            curNode.next = middle; 
            middle = curNode;
            curNode = nxtNode; 
        }

        originMiddle.next = middle;     //re-link the reversed half
        
        //8 7 6 5 4 3 2 1 true
        //8 7 6 5 1 2 3 4 5 1   <---- loop 以后的多出来的
        //这里原有middle还是在正常序列中，因为无法改动middle前一个node的next
        //但实际reverse的数列包括原有middle，把原有middle的next指定为最后反转的那个node之后，形成一个loop
        //但是达到了反转一半的结果
        //To improve: 1. clean half reverse; 2. reinstate the list order 

        return middle;
    }

}
