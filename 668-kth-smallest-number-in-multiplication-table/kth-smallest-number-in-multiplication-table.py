class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        l = 1
        r = m*n
        total = m*n

        def lessthan(i):
            row = m
            count = 0
            for col in range(1,n+1):
                while row>0 and row*col>= i:
                    row -= 1
                count+=row
            return count
        def greaterthan(i):
            row = m
            count = 0
            for col in range(1,n+1):
                while row>0 and row*col> i:
                    row -= 1
                count+=(m-row)
            return count

        while l<=r:
            mid = l + (r-l)//2
            lthan = lessthan(mid)
            gthan = greaterthan(mid)
            equal = total - lthan - gthan

            #print(mid,lthan,gthan,equal)

            if lthan<k<=lthan+equal:return mid
            elif k<=lthan: r= mid-1
            else: l = mid+1
        return 0 


