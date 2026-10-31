class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        l = 1
        r = m*n
        total = m*n

        def lessthan(i):
            row = m
            count = 0
            equal = 0
            for col in range(1,n+1):
                while row>0 and row*col>= i:
                    if row*col==i: equal+=1
                    row -= 1
                count+=row
            return [count,equal,total-count-equal]


        while l<=r:
            mid = l + (r-l)//2
            mat = lessthan(mid)
            lthan = mat[0]
            gthan = mat[2]
            equal = mat[1]
            #print(mid,lthan,gthan,equal)

            if lthan<k<=lthan+equal:return mid
            elif k<=lthan: r= mid-1
            else: l = mid+1
        return 0 


