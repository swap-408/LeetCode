class Solution:
    def maxSelectedElements(self, nums: List[int]) -> int:
        mp = {}
        nums.sort()
        for k in range(len(nums)-1,-1,-1):
            i = nums[k]
            mp[i] = max(mp.get(i,0),1+ mp.get(i+1,0))
            mp[i+1] = max(mp.get(i+1,0),1+mp.get(i+2,0))
        return max(mp.values())
        
        