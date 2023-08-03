#https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        
        if not head: return False
        
        # slow, fast = head, head.next #如果有有loop，迟早都要相遇，错开第一步来简化while loop的第一个iteration相等问题
        slow, fast = head, head #这个处理再while之后先走再判断，逻辑倒过来
        
        # while slow != fast: 
            
        #     #结束条件为fast走完，或者即将走完
        #     if fast is None or fast.next is None: return False
            
        #     # 1:2 move
        #     slow = slow.next
        #     fast = fast.next.next
        
        while fast is not None and fast.next is not None: 
            
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast: return True
            
        #如果slow=fast了，说明有loop
        return False
    
        # node_seen = set()

        # while head is not None:
            
        #     if head in node_seen:
        #         return True
        #     else: 
        #         node_seen.add(head) 

        #     head = head.next

        # return False