class Solution {
    public int maxProfit(int t, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][t+1];
        if (n == 0 || t == 0) return 0;
        for(int i=n-1;i>=0;i--){
            for(int k=1;k<=t;k++){
                dp[i][1][k] = Math.max(
                    -prices[i] + dp[i + 1][0][k],
                    dp[i + 1][1][k]
                );

                dp[i][0][k] = Math.max(
                    prices[i] + dp[i + 1][1][k - 1],
                    dp[i + 1][0][k]
                );
            }
        }
        return dp[0][1][t];


    }
}