#https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        
        slow = 0
        fast = 0 
        window_sum = 0
        length = 0
        
        while fast < len(nums):
            
            window_sum += nums[fast]
            
            while window_sum >= target: 
                print(window_sum)
                
                if not length: length = fast-slow+1
                else: length = min(length, fast-slow+1)
                
                window_sum -= nums[slow]
                slow += 1
                
            fast += 1
        
        return length
        