class Solution {
    public int rob(int[] nums) {
        int res =nums[0], n = nums.length;
        if(n<=2) return n==2 ? Math.max(nums[0],nums[1]) : nums[0];
        int prev1 = nums[0], prev2 = 0, curr = nums[0];
        for(int i=1;i<nums.length-1;i++){
            curr = Math.max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        res = curr;
        curr = 0; prev1=0; prev2 = 0;
        for(int i=1;i<nums.length;i++){
            curr = Math.max(prev1,prev2+nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        res =Math.max(res,curr);
        return res;
    }
}