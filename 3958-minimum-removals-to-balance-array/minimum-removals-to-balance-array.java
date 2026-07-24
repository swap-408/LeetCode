class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, ans = n;

        for (int j = 0; j < n; j++) {
            while (i <= j && (long) nums[j] > (long) k * nums[i]) {
                i++;
            }
            ans = Math.min(ans, n - (j - i + 1));
        }

        return ans;
    }
}