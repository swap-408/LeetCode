class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        if len(nums)==3: return 0
        nums.sort()
        temp = nums[-1]-nums[0]
        temp2 = nums[-2]-nums[1]
        temp3 = nums[-1]-nums[2]
        temp4 = nums[-3]-nums[0]

        return min(temp,temp2,temp3,temp4)


