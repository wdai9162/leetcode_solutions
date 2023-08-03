#https://leetcode.com/problems/intersection-of-two-linked-lists/editorial/

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        
        #brutle force 
        # while headA is not None:
        #     pointer_B = headB #otherwise headB is modified for every loop
        #     while pointer_B is not None: 
        #         if headA == pointer_B: return headA
        #         pointer_B = pointer_B.next 
        #     headA=headA.next 
        
        # return None
    
        #hash set
        # node_seen = set() 
        
        # while headA is not None: 
        #     node_seen.add(headA)
        #     headA = headA.next 
        
        # while headB is not None: 
        #     if headB in node_seen: return headB 
        #     headB = headB.next 
        # return None
        
        #Two Pointers
        #pointer_A goes through ListA_Distinct + Shared_section + ListB_Distinct 
        #pointer_B goes through ListB_Distinct + Shared_section + ListA_Distinct 
        #这样就把长度不等的问题抵消掉了，当最后重新开始走短的ListX_Distinct的时候，起跑线就一样了，如果有相同的node，就说明有交集
        
        pointer_A = headA
        pointer_B = headB 
        
        while pointer_A != pointer_B:
            
            if pointer_A is None: pointer_A = headB #ListA_Distinct + Shared_section finished
            else: 
                pointer_A = pointer_A.next
        
            if pointer_B is None: pointer_B = headA #ListA_Distinct + Shared_section finished
            else: 
                pointer_B = pointer_B.next
        
        return pointer_A
            