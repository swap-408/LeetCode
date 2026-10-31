class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        l = 1
        r = m*n
        total = m*n

        def lessthan(x):
            count = 0
            for i in range(1,m+1):
                count += min(x//i,n)
            return count >= k


        while l<r:
            mid = l + (r-l)//2
            #print(mid,lthan,gthan,equal)

            if not lessthan(mid):l = mid+1
            else: r = mid
        return l


