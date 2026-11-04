class Solution:
    def findTargetSumWays(self, nums: list[int], target: int) -> int:
        @cache
        def recurse(i,csum):
            if i==len(nums):
                if csum==target: return 1
                else: return 0
            
            res = 0
            res += recurse(i+1,csum+nums[i])
            res += recurse(i+1,csum-nums[i])

            return res

        return recurse(0,0)