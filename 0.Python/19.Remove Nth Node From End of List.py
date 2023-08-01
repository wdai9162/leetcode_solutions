# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        sz = 0
        sentinel = ListNode(0)
        sentinel.next = head
        pointer = head
        
        while pointer != None:
            pointer = pointer.next
            sz += 1
        
        pointer = sentinel
        for _ in range(sz-n):
            pointer = pointer.next
        
        pointer.next = pointer.next.next

        return sentinel.next