class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==2) return 2;
        if(n==1) return 1; 
        
        int k=1;
        while(k<Integer.MAX_VALUE && k<=n){
            k *= 2;
        }
        return k;
    }
}