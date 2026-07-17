class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0,n=nums.length;
        while(j<n){
            int temp;
            if(nums[j]!=0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;
        }
        return;
    }
}