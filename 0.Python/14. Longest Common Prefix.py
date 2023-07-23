#https://leetcode.com/problems/longest-common-prefix/

from typing import List

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        prefix = ""
        
        for c_index, c in enumerate(strs[0]):
            
            i = 0
            
            while i < len(strs) and c_index < len(strs[i]) and c == strs[i][c_index]:     
                
                i += 1
                
            if i == len(strs): prefix += c
        
        return prefix