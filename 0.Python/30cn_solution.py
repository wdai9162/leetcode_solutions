#https://leetcode.cn/leetbook/read/illustration-of-algorithm/50bp33/
#https://leetcode-cn.com/problems/min-stack/


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.val = []
        self.min_list = []


    def push(self, x: int) -> None:
        self.val.append(x)
        # if len(self.min_list) == 0: self.min_list.append(x)
        # elif x <= self.min_list[-1]: 
        #     self.min_list.append(x)
        if not self.min_list or x <= self.min_list[-1]:
            self.min_list.append(x)
            
    def pop(self) -> None:
        # if len(self.val) == 0: return None
        if not self.val: return None
        
        # if self.val[-1] == self.min_list[-1]: 
        #     self.val.pop()
        #     self.min_list.pop()
        # else: 
        #     self.val.pop()
        if self.val.pop() == self.min_list[-1]:
            self.min_list.pop()
            
    def top(self) -> int:
        # if len(self.val) == 0: return None
        if not self.val: return None 
        return self.val[-1]

    def min(self) -> int:
        if not self.val: return None 
        return self.min_list[-1]

#调用 min、push 及 pop 的时间复杂度都是 O(1)。

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.min()