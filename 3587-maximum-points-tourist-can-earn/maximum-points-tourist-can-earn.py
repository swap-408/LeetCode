class Solution:
    def maxScore(self, n: int, k: int, stayScore: List[List[int]], travelScore: List[List[int]]) -> int:
        
        dp = [0]*n
        
        for d in range(k):
            temp = [0]*n
            for dest in range(n):
                ans = 0
                for curr in range(n):
                    ans = max(ans, dp[curr]+travelScore[curr][dest])
                temp[dest] = max(dp[dest]+stayScore[d][dest], ans)
            dp = temp
        
        return max(dp)