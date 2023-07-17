#https://leetcode.cn/leetbook/read/illustration-of-algorithm/58o46i/
#https://leetcode-cn.com/problems/sliding-window-maximum/

from typing import List 
from collections import deque 

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:

        # #brutal force solution ~ O(kN), too slow to finish in webportal
        # if k > len(nums): return None
        
        # start = 0 
        # end = k-1
        # res = []
        
        # while end < len(nums):
        #     max = None
        #     i = start 
            
        #     while i <= end:
        #         if not max or nums[i] > max: max = nums[i]
        #         i += 1
                
        #     res.append(max)
        #     start += 1
        #     end += 1
        #     print(len(res))
            
        # print(res)
        # return res

        # dequeue solution
        
        # before full window K is established 
        
        if not nums or k == 0: return []
        
        start = 0
        end = k-1 
        deq = deque()
        ans = []
        # form the initial window
        for i in range(end+1):
            while deq and nums[i]> deq[-1]:
                deq.pop()
            deq.append(nums[i])
            
        ans.append(deq[0])
        # start window sliding
        while end < len(nums)-1:
            start += 1
            end += 1
            print (deq)
            # if nums[end] >= max/deq[0]
            if nums[start-1] == deq[0]: deq.popleft()
            while deq and nums[end] > deq[-1]:
                deq.pop()
            deq.append(nums[end])
            ans.append(deq[0])
        
        print(ans)
        return ans


nums=[3,0,3,3,0,1,2,3,6,7,8,9,0,3,1,2]                
k=5        
a = Solution()
a.maxSlidingWindow(nums,k)
            
                
                
                
        
        