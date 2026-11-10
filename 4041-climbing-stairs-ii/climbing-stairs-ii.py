class Solution:
    def climbStairs(self, n: int, cost: List[int]) -> int:
        costi = 0
        cost1 = cost[0]+1
        if n==1: return cost1
        cost2 = cost[1]+min(cost1+1,4)
        if n==2: return cost2
        cost3 = cost[2] + min(cost2+1,cost1+4,9)
        if n==3: return cost3

        for i in range(3,n):
            costi = cost[i]+min(cost3+1,cost2+4,cost1+9)
            cost1 = cost2
            cost2 = cost3
            cost3 = costi
        return costi