#https://leetcode.cn/leetbook/read/illustration-of-algorithm/58o46i/
#https://leetcode-cn.com/problems/sliding-window-maximum/

from typing import List 

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:

        if len(nums) <= k: return max(nums)

        for i in range(0,k):