class Solution:
    def maxScore(self, nums1: list[int], nums2: list[int], k: int) -> int:
        arr = sorted(zip(nums2, nums1), reverse=True)
        asum = 0
        hp = []
        res = 0
        for i in range(len(arr)):
            curr = arr[i]
            asum += curr[1]
            if len(hp)==(k-1):
                res = max(res,curr[0]*asum)
            heapq.heappush(hp,curr[1])
            if len(hp)==k:
                asum -= hp[0]
                heapq.heappop(hp)
        return res
            

