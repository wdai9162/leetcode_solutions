#https://leetcode.com/explore/learn/card/array-and-string/204/conclusion/1164/

class Solution:
    def reverseWords(self, s: str) -> str:
        
        split = s.split()
        res = " ".join(split[::-1])

        return res
                
                
                
                
                
        