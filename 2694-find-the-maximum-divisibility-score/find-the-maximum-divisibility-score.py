class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        ans =0
        res = float('inf')
        for i in divisors:
            temp=0
            for j in nums:
                if j%i==0: temp+=1
            if temp>ans:
                ans = temp
                res = i
            elif temp==ans:
                res = min(i,res)
        return res