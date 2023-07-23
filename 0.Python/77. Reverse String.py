#https://leetcode.com/problems/reverse-string/

from typing import List

class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if not s: return None
       
        i = 0 
        tmp = None
        j = len(s)-1
        
        while i < j: 
            
            # tmp = s[i]    
            # s[i] = s[j]
            # s[j] = tmp
            
            #to do this without a tmp
            
            s[i], s[j] = s[j], s[i]
            
            i += 1
            j -= 1