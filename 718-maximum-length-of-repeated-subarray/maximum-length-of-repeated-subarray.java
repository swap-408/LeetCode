class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findLength(nums2,nums1);
        int res = 0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    int currLength = 1;
                    int idx1 = i+1, idx2 = j+1;
                    while(idx1 < nums1.length && idx2<nums2.length && nums1[idx1]==nums2[idx2]){
                        currLength++;
                        idx1++; idx2++;
                    }
                    res = Math.max(currLength,res);
                }
            }
        }
        return res;
    }
}