class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];

        for (int c = 0; c < n; c++) {
            dp[c] = points[0][c];
        }

        for (int r = 1; r < m; r++) {
            long[] left = new long[n];
            long[] right = new long[n];
            long[] next = new long[n];

            left[0] = dp[0];
            for (int c = 1; c < n; c++) {
                left[c] = Math.max(left[c - 1] - 1, dp[c]);
            }

            right[n - 1] = dp[n - 1];
            for (int c = n - 2; c >= 0; c--) {
                right[c] = Math.max(right[c + 1] - 1, dp[c]);
            }

            for (int c = 0; c < n; c++) {
                next[c] = points[r][c] + Math.max(left[c], right[c]);
            }

            dp = next;
        }

        long res = 0;
        for (long x : dp) res = Math.max(res, x);
        return res;
    }
}