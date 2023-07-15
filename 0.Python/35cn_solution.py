#https://leetcode.cn/leetbook/read/illustration-of-algorithm/9p0yy1/
#https://leetcode-cn.com/problems/copy-list-with-random-pointer/



# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        
        previous_node = None
        old_head_location = head         
        new_head_location = None
        
        while head: 

            new_head = Node(head.val)
            if not new_head_location: new_head_location = new_head
            if previous_node: previous_node.next = new_head
            previous_node = new_head
            head = head.next
        
        head = old_head_location
        new_head = new_head_location
        
        while head:
            new_head.random = head.random
            
            s