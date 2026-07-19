class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int m = binarySearch(nums,target-nums[i]-nums[j],j+1,nums.length-1);
                if(m!=-1 && Math.abs(target-nums[i]-nums[j]-nums[m])<Math.abs(res)){
                    res = target-nums[i]-nums[j]-nums[m];
                }
            }
        }
        return target - res;
    }

    public int binarySearch(int[] nums, int diff, int s, int e){
        int l = s, r= e, m = 0, res=-1;
        while(l<=r){
            m = l + (r-l)/2;
            if(res==-1 || Math.abs(diff-nums[m]) < Math.abs(diff-nums[res])) res = m;
            if(nums[m]==diff) return res;
            else if(nums[m]<diff){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return res;
    }
}