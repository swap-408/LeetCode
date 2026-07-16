class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] maxA = new int[n];
        int m= nums[0];
        for(int i=0;i<n;i++){
            m = Math.max(m,nums[i]);
            maxA[i] = gcd(m,nums[i]);
        }
        Arrays.sort(maxA);
        int i=0, j= n-1;
        long res = 0;
        while(i<j){
            res += gcd(maxA[i],maxA[j]);
            i++; j--;
        }
        return res;
    }
    public int gcd(int a, int b){
        if(a>b) return gcd(b,a);
        if(a==0) return b;
        return gcd(b%a,a);
    }
}