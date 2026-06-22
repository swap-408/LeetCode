class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r =0;
        for(int i: nums){
            l = Math.max(l,i);
            r += i;
        }

        int mid =0, res = r;
        while(l<=r){
            mid = l+(r-l)/2;
            int c = 1,s=0;
            for(int i:nums){
                if(s+i>mid){
                    s = 0; c++;
                }
                s += i;
            }
            if(c>k) l = mid +1;
            else{
                res = Math.min(res,mid);
                r = mid -1;
            }
        }
        
        return res;
    }
}