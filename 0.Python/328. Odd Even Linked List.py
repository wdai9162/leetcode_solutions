# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        if not head or not head.next: return head
        
        odd_dummy = ListNode(0)
        even_dummy = ListNode(0)
        
        odd_cur = odd_dummy 
        even_cur = even_dummy
        
        cur = head
        is_odd = True 
        
        while cur is not None: 
            
            if is_odd: 
                odd_cur.next = cur
                odd_cur = odd_cur.next
            else: 
                even_cur.next = cur 
                even_cur = even_cur.next 
                
            is_odd = not is_odd
            cur = cur.next
        
        even_cur.next = None
        odd_cur.next = even_dummy.next 
        
        return odd_dummy.next 