package solutionpackage;

import java.util.spi.CurrencyNameProvider;

//Design Linked List
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

    public boolean hasCycle() {
        
        //two pointers solution，space complexity = O(1)
        //Brutle force uses hashset，check element 1 by 1，space complexity = O(n)

        if (head == null || head.next == null) {
            return false; 
        } 
        
        Node slow = head; 
        Node fast = head.next; 
        
        while(slow != fast) {
            
            if (fast == null || fast.next == null ) {  //need to check fast and fast.next in order，the sequence matters，otherwise if fast itslef is null fast.next will throw an error
                return false; 
            }

            slow = slow.next;
            fast = fast.next.next;
            
        }
        
        return true;
    }

    
}
