# https://leetcode.com/problems/remove-element/

from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        
        if not nums: return 0
        
        i = 0
        j = len(nums) - 1
        
        while i <= j: 
            
            # moving both I and J together make things complicated
            # move 1 at a time though it means more loops on reader pointer i
                    
            
            if nums[i] == val:
                
                nums[i] = nums[j]
                j -= 1
            
            else: 
                
                i += 1
                
        return j+1
        