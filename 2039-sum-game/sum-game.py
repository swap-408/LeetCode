class Solution:
    def sumGame(self, num: str) -> bool:
        rsum = 0
        lsum = 0
        lq = 0
        rq = 0
        n = len(num)
        for i in num[:n//2]:
            if i=='?':
                lq +=1
            else:
                lsum += int(i)
        
        for i in num[n//2:]:
            if i=='?':
                rq +=1
            else:
                rsum += int(i)
        
        if 2*(lsum-rsum)+9*(lq-rq)==0: return False
        return True