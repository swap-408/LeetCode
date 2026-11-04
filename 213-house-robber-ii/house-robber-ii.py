class Solution:
    def rob(self, nums: list[int]) -> int:
        if len(nums)==1: return nums[0]
        def rob2(nums):
            n = len(nums)
            b1 = nums[0]
            if n==1: return b1
            b2 = max(nums[0],nums[1])
            res = b2
            for i in range(2,n):
                res = max(b1+ nums[i],b2)
                b1 = b2
                b2 = res
            return res
        
        return max(rob2(nums[:-1]),rob2(nums[1:]))