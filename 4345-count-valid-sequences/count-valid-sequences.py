class Solution:
    def countValidSequences(self, n: int, k: int) -> int:
        total = 0
        odd = 0

        if k<0 or k>n: return 0
        if k==1 and n%2==0: return 1
        if k==1 and n%2==1: return 0
        total = comb(n-1,k-1)

        odd = 0 if (n-k)%2==1 else comb((n-k)//2+k-1,k-1) 
        return (total-odd)%(10**9+7)