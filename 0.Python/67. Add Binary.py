#https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        
        length = max(len(a),len(b))
        res = []
        
        #fill the shorter string to the same length, to simplify the calculation
        a = a.zfill(length)
        b = b.zfill(length)
        
        #here the digit sum and carry_over are both factored into "carry"
        carry = 0 
        
        #a=[11001]
        #b=[00011]
        #c=[00000] imagine this is the sum and carry
        
        for i in range(length-1, -1, -1): #iterate in reverse order

            if a[i] == "1": 
                carry += 1

            
            if b[i] == "1":
                carry += 1
            
            #therefore the carry can be 0, 1, 2, 3
            if carry%2 == 1:    #if carry is 1 or 3
                res.append("1") 
            else:               #if carry is 0 or 2
                res.append("0")
                
            #upon until this step, the calculation in this digit/bit is finished
            #the remaining is to determine whether carry needs to be carried into the next digit
            
            # if carry was 3 or 2, answered appended 1 or 0, both should carry over 1
            # carry //= 2 does this job better than if...

            if carry == 3 or carry == 2: 
                carry = 1
            else: 
                carry = 0
        
        #if the highest bit carries over afterall 
        if carry == 1: res.append("1")
        
        return "".join(res[::-1])