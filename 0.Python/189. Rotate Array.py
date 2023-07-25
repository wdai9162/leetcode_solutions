#https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1182/

from typing import List 

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        tmp = nums.copy()
        
        k = k%len(nums)
        
        if k == 0 or len(nums) == 1: return 
        
        nums[:k] = tmp[-k:]
        nums[k:] = tmp[:-k]
        
        return