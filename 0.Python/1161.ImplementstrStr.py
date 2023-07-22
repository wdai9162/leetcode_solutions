#https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1161/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if len(needle) > len(haystack): return -1
        
        for i in range(len(haystack)):

            j = 0
            z = i
            
            while j < len(needle) and z < len(haystack) and haystack[z] == needle[j]:

                z += 1
                j += 1
            
            if j == len(needle): return i
            
        return -1


a = Solution()
a.strStr("mississippi","issipi")