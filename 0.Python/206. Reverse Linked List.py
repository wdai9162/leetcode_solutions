# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        cur = head
        
        while head and cur.next is not None: 
            
            tmp = cur.next
            cur.next = cur.next.next 
            tmp.next = head
            head = tmp 
        
        return head 