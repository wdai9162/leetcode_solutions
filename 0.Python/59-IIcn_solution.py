#https://leetcode.cn/leetbook/read/illustration-of-algorithm/e2t5ug/

class MaxQueue:

    def __init__(self):
        self.val = []
        self.max = [] 

    def max_value(self) -> int:
        if not self.val: return -1
        return self.max[-1]


    def push_back(self, value: int) -> None:

        self.val.append(value)
        if not self.max or self.max[-1] <= value:
            self.max.append(value)

    def pop_front(self) -> int:
        if not self.val: return -1
        pop = self.val[0]
        if pop == self.max[0]: self.max = self.max[1:]
        self.val = self.val[1:]
        return pop


# Your MaxQueue object will be instantiated and called as such:
# obj = MaxQueue()
# param_1 = obj.max_value()
# obj.push_back(value)
# param_3 = obj.pop_front()