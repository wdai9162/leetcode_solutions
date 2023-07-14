#https://leetcode.cn/leetbook/read/illustration-of-algorithm/5d3i87/    
#09. 用两个栈实现队列

class CQueue:

    def __init__(self):
        self.a, self.b = [] , []

    def appendTail(self, value: int) -> None:
        return self.a.append(value)

    def deleteHead(self) -> int:
        while self.a:
            self.b.append(self.a.pop())
        if self.b:
            delete = self.b.pop()
            self.a = self.b[::-1]
            self.b = []
            return delete
        else:
            return -1



# Your CQueue object will be instantiated and called as such:
# obj = CQueue()
# obj.appendTail(value)
# param_2 = obj.deleteHead()