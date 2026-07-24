class Solution {
    public int minOperations(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        if((n&1)==0) return minOperations(n>>1);
        return 1+Math.min(minOperations((n-1)>>1),minOperations((n+1)>>1));
    }
}