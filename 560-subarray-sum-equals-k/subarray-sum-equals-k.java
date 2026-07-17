class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int res = 0;
        int curr = 0;
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            curr += nums[i];
            res += mp.getOrDefault(curr-k,0);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        return res;
    }
}