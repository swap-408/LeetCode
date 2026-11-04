class Solution:
    def canPartition(self, nums: list[int]) -> bool:
        total = sum(nums)
        if total%2==1: return False
        half = total//2

        dp = [0]*(half+1)
        dp[0] = 1
        for num in nums:
            for j in range(half,num-1,-1):
                dp[j] += dp[j-num]
        return True if dp[half]>=1 else False