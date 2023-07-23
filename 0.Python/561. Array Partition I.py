#https://leetcode.com/problems/array-partition/

from typing import List

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        
        nums.sort()

        maxPair = 0 

        for i in range(0,len(nums),2):

            maxPair += nums[i]
        
        return maxPair
