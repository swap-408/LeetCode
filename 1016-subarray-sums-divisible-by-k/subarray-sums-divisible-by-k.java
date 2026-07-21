class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] arr = new int[k];
        arr[0] = 1;
        int count = 0, res=0;
        for(int i=0;i<nums.length;i++){
            count += nums[i];
            int mod = count%k;
            if (mod < 0) mod += k;

            if(arr[mod]!=0) res += arr[mod];
            arr[mod]++;
        }
        return res;
    }
}