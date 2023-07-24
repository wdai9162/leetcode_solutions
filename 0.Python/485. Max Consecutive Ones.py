# https://leetcode.com/problems/max-consecutive-ones/

from typing import List

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        
        starter = 0
        max_ones = 0 
        run_flag = False
        
        while starter < len(nums): 
            run_flag = False
            checker = starter
            
            while checker < len(nums) and nums[starter] == 1 and nums[checker] == 1: 
                run_flag = True 
                checker += 1
            
            max_ones = max(max_ones, checker-starter)
            
            if run_flag: starter = checker + 1
            else: starter += 1
            
        return max_ones