# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        
        if not head: return head
        
        dummy = ListNode(0)
        dummy.next = head 
        
        pre = dummy 
        cur = head
        
        while cur is not None: 
            
            #edge 1 - tail match 
            #edge 2 - head match or multiple head match
            
            if cur.val == val:
                pre.next = cur.next
                cur = cur.next
            else: 
                pre = cur
                cur = cur.next 
        
        return dummy.next 