class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0, zeros = 0;
        for(int i=0,j=0;i<nums.length && j<nums.length;i++){
            if(nums[i]==1){
                res = Math.max(res,i-j+1);
                continue;
            }
            zeros++;
            if(zeros<=k){
                res = Math.max(res,i-j+1);
                continue;
            }
            while(j<=i){
                if(zeros<=k) break;
                if(nums[j]==0) zeros--;
                j++;
            }
        }

        return res;
    }
}