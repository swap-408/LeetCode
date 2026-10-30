class Solution:
    def maxScore(self, nums1: list[int], nums2: list[int], k: int) -> int:
        arr = sorted(zip(nums2, nums1), reverse=True)
        asum = 0
        hp = []
        res = 0
        for n1,n2 in arr:
            
            asum += n2
            if len(hp)==(k-1):
                res = max(res,n1*asum)
            heapq.heappush(hp,n2)
            if len(hp)==k:
                asum -= heapq.heappop(hp)
        return res
            

