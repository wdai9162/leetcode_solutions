#https://leetcode.cn/leetbook/read/illustration-of-algorithm/589fz2/
class Solution:
    def reverseLeftWords(self, s: str, n: int) -> str:
        #abcdefg
        # return s[n:]+s[:n]   #solution 1 O(N) + O(N)

        # if slice notation is NOT allowed
        # end = ""
        # start = "" 

        # for i,char in enumerate(s):
        #     if i < n: end += char
        #     else: start += char
        # return start+end

        # the Sring way ---> low efficiency due to multiple strings created
        # res = "" 
        # for i in range(n,len(s)):
        #     res += s[i]
        # for i in range(n):
        #     res += s[i]

        # return res
    
        # the Array way
        res = []
        for i in range(n,len(s)):
            res.append(s[i])
        for i in range(0,n):
            res.append(s[i])
        
        return "".join(res)
