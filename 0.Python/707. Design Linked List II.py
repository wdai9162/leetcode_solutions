#Doubly Linked List
#not working yet 

class Node: 
    def __init__(self, val: int):
        self.val = val
        self.next = None
        self.pre = None


class MyLinkedList:
    
    def __init__(self):
        self.sentinel_head = Node(0)
        self.sentinel_tail = Node(0)
        self.sentinel_head.next = self.sentinel_tail
        self.sentinel_tail.pre = self.sentinel_head
        self.length = 0
        
    def get(self, index: int) -> int:
        
        if index >= self.length: return -1
        
        if index < self.length/2:
            cur = self.sentinel_head
            for _ in range(0, index+1):
                cur = cur.next
            return cur.val
        
        elif index >= self.length/2:
            cur = self.sentinel_tail
            for _ in range(0, self.length-index):
                cur = cur.pre
            return cur.val
    
    def addAtIndex(self, index: int, val: int) -> None:
        
        if index > self.length: return
        
        if index < self.length/2:
            cur = self.sentinel_head
            for _ in range(0, index):                #go to the node before indexth node
                cur = cur.next
        elif index >= self.length/2:
            cur = self.sentinel_tail
            for _ in range(0, self.length-index+1):  #go to the node before indexth node
                cur = cur.pre
        
        tmp = cur.next
        cur.next = Node(val)
        cur.next.next = tmp
        cur.next.pre = cur
        tmp.pre = cur.next
        self.length += 1

    def addAtHead(self, val: int) -> None:
        
        self.addAtIndex(0, val)
        
    def addAtTail(self, val: int) -> None:
        
        self.addAtIndex(self.length, val)

    def deleteAtIndex(self, index: int) -> None:
        
        if index > self.length: return
        
        if index < self.length/2:
            cur = self.sentinel_head
            for _ in range(0, index):                #go to the node before indexth node
                cur = cur.next
        elif index >= self.length/2:
            cur = self.sentinel_tail
            for _ in range(0, self.length-index+1):  #go to the node before indexth node
                cur = cur.pre
        
        cur.next = cur.next.next
        cur.next.pre = cur
        self.length -= 1