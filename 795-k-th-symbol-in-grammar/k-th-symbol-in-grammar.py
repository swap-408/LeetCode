class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        if n==1 and k==1: return 0
        if n==2 and k==1: return 0
        if n==2 and k==2: return 1


        return self.kthGrammar(n-1,(k+1)//2)^1 if k%2==0 else self.kthGrammar(n-1,(k+1)//2)