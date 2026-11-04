class Solution:
    def findTargetSumWays(self, nums: list[int], target: int) -> int:
        
        total = sum(nums)
        if abs(target)>total or (total+target)%2!=0:
            return 0
        P = (target+total)//2
        dp = [0]*(P+1)
        dp[0] = 1
        for num in nums:
            for j in range(P,num-1,-1):
                dp[j] += dp[j-num]
        return dp[P]