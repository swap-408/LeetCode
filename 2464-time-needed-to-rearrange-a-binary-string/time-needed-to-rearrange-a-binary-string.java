class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zeros = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                zeros++;
            } else if (zeros > 0) {
                ans = Math.max(ans + 1, zeros);
            }
        }

        return ans;
    }
}