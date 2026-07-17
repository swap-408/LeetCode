class Solution {
    public int[] sortedSquares(int[] nums) {
        int p=nums.length,n=-1;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0){
                p = i;
                break;
            }
        }   
        n = p-1;
        for(int i=0;i<res.length;i++){
            int a = 100000, b =100000;
            if(n>=0) a = (-1)*nums[n];
            if(p<nums.length) b = nums[p];
            
            if(a<b){
                res[i] = a*a;n--;
            }else{
                res[i] = b*b;p++;
            }
        }
        return res;
    }
}