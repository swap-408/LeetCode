class Solution {
    public boolean canJump(int[] nums) {
        int end =0, far=0;
        for(int i=0;i<nums.length && i<=end;i++){
            far = Math.max(far,i+nums[i]);
            if(i==end){
                end = far;
            }
        }

        if(far>=nums.length-1) return true;
        return false;
    }
}