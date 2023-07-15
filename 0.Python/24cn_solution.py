#https://leetcode.cn/leetbook/read/illustration-of-algorithm/9pdjbm/
#https://leetcode-cn.com/problems/reverse-linked-list/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head: 
            return None 
        
        temp, previous = None, None 
        
        while head: 
            temp = head.next 
            head.next = previous
            previous = head 
            head = temp
        
        return previous
    
    #递归解法