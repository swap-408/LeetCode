class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        back2 = nums[0]
        if n==1: return back2
        back1 = max(nums[0],nums[1])
        res = back1
        for i in range(2,n):
            res = max(back2+nums[i],back1)
            back2 = back1
            back1 = res
        return res
        