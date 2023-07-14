#https://leetcode.cn/leetbook/read/illustration-of-algorithm/5dt66m/
#06. 从尾到头打印链表

import List
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        node = head
        res = []
        while node is not None:
            res.append(node.val)
            node = node.next
        return res[::-1]
    
    def reversePrint2(self, head: ListNode) -> List[int]:
        node = head
        res = []
        while node is not None:
            res.append(node.val)
            node = node.next
        
        #再建一个数组，给反转过来，下下策
        index = len(res)-1
        answer = []
        while index >=0: 
            answer.append(res[index])
            index -= 1
        return answer
    
    def reversePrint3(self, head: ListNode) -> List[int]:
        #递归解法, time = O(N); space = O(N)

        #1. 定义终止条件： 当 head == None 时，代表越过了链表尾节点，则返回空列表；
        if head is None:
            return []
        #2. 递推工作： 访问下一节点 head.next
        res = self.reversePrint3(head.next) + [head.val]

        #3. 回溯阶段:
        return res
    
    def reversePrint4(self, head: ListNode) -> List[int]:
        #用“栈”来辅助先入后出 
        stack = []
        while head: 
            stack.append(head.val)
            head = head.next
        
        # res = []
        # while stack: 
        #     res.append(stack.pop())
        # return res
        return stack[::-1]