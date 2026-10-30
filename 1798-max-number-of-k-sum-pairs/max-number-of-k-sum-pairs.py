class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        nums.sort()
        l,r,count = 0,len(nums)-1,0
        while l<r:
            t = nums[l]+nums[r]
            if t==k:
                l += 1
                r -= 1
                count += 1
            elif t<k:
                l += 1
            else:
                r -= 1
        return count