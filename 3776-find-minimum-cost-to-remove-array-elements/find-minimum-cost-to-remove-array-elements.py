class Solution:
    def minCost(self, nums: List[int]) -> int:

        def cal(idx,start,nums,dp):
            if start == len(nums):
                return nums[idx]
            if start == len(nums)-1:
                return max(nums[start],nums[idx])
            
            if dp[idx][start] != -1:
                return dp[idx][start]
            
            f = max(nums[start],nums[start+1]) + cal(idx,start+2,nums,dp)
            s = max(nums[idx],nums[start+1]) + cal(start,start+2,nums,dp)
            t = max(nums[idx],nums[start]) + cal(start+1,start+2,nums,dp)

            dp[idx][start] = min(f,s,t)
            return dp[idx][start]
        
        dp = [[-1]*(len(nums)) for _ in range(len(nums))]

        return cal(0,1,nums,dp)

        
        