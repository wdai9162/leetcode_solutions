#https://leetcode.cn/leetbook/read/illustration-of-algorithm/e2t5ug/

class Solution:
    def strToInt(str: str) -> int:
        
        
        ans = None
        int_min = (-2)**31
        int_max = 2**31-1
        
        str=str.strip()
        if not str: print("nothing"); return 0
        
        numbers = {
            "1": "1",
            "2": "2",
            "3": "3",
            "4": "4",
            "5": "5",
            "6": "6",
            "7": "7",
            "8": "8",
            "9": "9",
            "0": "0",
        }
        
        signs = {
            "-": "-",
            "+": "+"
        }
            
        if str[0] in numbers:
            i = 0
            while i < len(str) and str[i] in numbers: 
                i += 1
            ans = str[:i]
        elif len(str) > 1 and str[0] in signs and str[1] in numbers:
            i = 1
            while i < len(str) and str[i] in numbers:
                i += 1
            ans = str[:i]
        else: ans = 0
        

        ans = int(ans)
        print(ans)
        if ans < int_min: return int_min 
        elif ans > int_max: return int_max
        else: return ans

a=" "
Solution.strToInt(a)