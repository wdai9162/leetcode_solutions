#using sentinel 

class Node: 
    def __init__(self, val: int):
        self.val = val
        self.next = None


class MyLinkedList:
    
    def __init__(self):
        self.sentinel_head = Node(0) #the linked list is initialised with this pseudo head
        self.length = 0     #pseudo head is not counted into the actual length 
        
    def get(self, index: int) -> int:
        
        if index >= self.length: return -1
        
        cur = self.sentinel_head
        for _ in range(0, index+1): #index + 1 due to pseudo head
            cur = cur.next
        return cur.val
            
    def addAtHead(self, val: int) -> None:
        
        # new_head = Node(val)
        # new_head.next = self.sentinel_head.next
        # self.sentinel_head.next = new_head
        # self.length += 1
        self.addAtIndex(0, val)
        
    def addAtTail(self, val: int) -> None:
        
        # cur = self.sentinel_head
        # while cur.next:              #go to the last node
        #     cur = cur.next
        
        # cur.next = Node(val)
        # self.length += 1
        self.addAtIndex(self.length, val)
        
    def addAtIndex(self, index: int, val: int) -> None:
        
        if index > self.length: return 

        cur = self.sentinel_head
        
        for _ in range(0,index):     #go to the node before indexth node
            cur = cur.next 
            
        tmp = cur.next 
        cur.next = Node(val)
        cur.next.next = tmp
        self.length += 1 

    def deleteAtIndex(self, index: int) -> None:
        
        if index >= self.length: return 
        
        cur = self.sentinel_head
        
        for _ in range(0, index):   #go to the node before indexth node
            cur = cur.next 
        
        cur.next = cur.next.next
        self.length -= 1
        
        
# class Node: 
#     def __init__(self, val: int):
#         self.val = val
#         self.next = None

# class MyLinkedList:
    
#     def __init__(self):
#         self.head = None
#         self.length = 0

#     def get(self, index: int) -> int:
        
#         if not self.head or index >= self.length: return -1
        
#         cur = self.head
        
#         for i in range(0,index):
#                 cur = cur.next
                
#         return cur.val

#     def addAtHead(self, val: int) -> None:
        
#         new_head = Node(val)
#         new_head.next = self.head
#         self.head = new_head
#         self.length += 1
#         print(self.length)
    

#     def addAtTail(self, val: int) -> None:
        
#         if not self.head:
#             self.head = Node(val)
#             self.length += 1
#             return 
        
#         cur = self.head
        
#         for _ in range(0,self.length-1):
#             cur = cur.next 
            
#         cur.next = Node(val)
#         self.length += 1
        

#     def addAtIndex(self, index: int, val: int) -> None:
        
#         if index > self.length: return
#         elif index == 0: self.addAtHead(val); return
#         # elif index == self.length: self.addAtTail(val); return
        
            
#         cur = self.head        
        
#         for _ in range(0, index-1):
#             cur = cur.next
            
#         temp = cur.next 
#         cur.next = Node(val)
#         cur.next.next = temp 
#         self.length += 1
        
#         return 

#     def deleteAtIndex(self, index: int) -> None:
        
#         if not self.head or index >= self.length: return
#         elif index == 0: self.head = self.head.next; return
        
#         pre = None 
#         cur = self.head
        
#         for _ in range(0, index):
#             pre = cur 
#             cur = cur.next
        
#         pre.next = cur.next 
#         self.length -= 1
        
#         return    
        
        


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)