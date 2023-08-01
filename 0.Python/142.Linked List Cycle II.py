#https://leetcode.com/problems/linked-list-cycle-ii/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        node_seen = set() 
        
        while head is not None: 
            
            if head in node_seen: 
                return head
            else:
                node_seen.add(head)
            
            head = head.next 
        
        return None