class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n==1 and k==1: return 0
        if n==2 and k==1: return 0
        if n==2 and k==2: return 1
        prevk = (k+1)//2
        
        c = self.kthGrammar(n-1,prevk)

        return c^1 if k%2==0 else c