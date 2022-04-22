package solutionpackage;

import java.util.HashSet;
import java.util.spi.CurrencyNameProvider;
import javax.naming.NamingException;


//Design Linked List / Double Linked List Cycle
public class MyDoubleLinkedList {

    Node head;
    int size = 0;

    class Node {
        int data; 
        Node previous,next; 
        
        //Constructor 
        Node(int d) {
            data = d; 
        }
    }

    public MyDoubleLinkedList() {
        
    }

    public void print() {
        for (int i = 0; i < this.size; i++ ){
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }    
        Node curNode = this.head;
        while (index > 0) {
            curNode = curNode.next;
            index--; 
        }
        return curNode.data;
    }


    public void addAtHead(int val) {

        Node newNode = new Node(val);

        if (this.head == null) {
            this.head = newNode;
            size++;
            return;
        }

        newNode.next = this.head; 
        this.head.previous = newNode;
        this.head = newNode; 
        size++;
    }

    public void addAtTail(int val) {

        Node newTail = new Node(val);

        if (this.head == null) {
            this.head = newTail;
            size++;
            return;
        }

        Node curNode = this.head;

        while (curNode.next != null) {
        
            curNode = curNode.next;
        }

        curNode.next = newTail; 
        newTail.previous = curNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        
        Node newNode = new Node(val);

        if ( index < 0 || index > size ) {
            return; 
        } else if (this.head == null || index == 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        }

        Node curNode = this.head;
        Node nextNode;

        while (index > 1) {
            curNode = curNode.next;
            index--; 
        }

        //        (cur)     (nxt)
        //x    x    x    y    x    x 
        System.out.println(curNode.data);
        nextNode = curNode.next;
        curNode.next = newNode;
        newNode.previous = curNode;
        newNode.next = nextNode; 
        nextNode.previous = newNode;
        size++;

    }

    public void deleteAtIndex(int index) {

        if ( index < 0 || index > size-1 ) {
            return; 
        } else if ( this.head == null ) {
            return;
        } else if ( index == 0 ){
            if (this.head.next == null){
                this.head = null;
            } else {
                this.head = head.next;
                this.head.previous = null;
            }
            size--;
            return;
        }
    
        Node curNode = this.head;
        Node nextNode;

        //        (cur)     (nxt)
        //x    x    x    y    x    x 

        while (index > 1) {
            curNode = curNode.next;
            index--; 
        }

        if ( curNode.next.next == null ){    //delete the tail node
            curNode.next = null;
        } else {
            nextNode = curNode.next.next;
            curNode.next = nextNode;
            nextNode.previous = curNode;
        }
        
        size--;
        
    }

}
