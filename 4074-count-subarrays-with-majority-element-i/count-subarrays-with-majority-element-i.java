class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int[] ps = new int[nums.length+1];
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target) count++;
            ps[i+1] = count;
        }
        int res =0;
        for(int i=1;i<=nums.length;i++){
            for(int j=i;j<=nums.length;j++){
                int half = (j-i+1)/2 + 1;
                if(half <= ps[j]-ps[i-1]){
                    res++;
                }
            }
        }
        return res;
    }
}