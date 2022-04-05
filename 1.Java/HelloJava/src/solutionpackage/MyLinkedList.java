package solutionpackage;

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

}
