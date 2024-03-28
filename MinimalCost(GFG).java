 class Solution {
    public static int minimizeCost(int n, int k, int[] heights) {
        int[] dp = new int[n];
        int right = 0;
        for (int i = 1; i < heights.length; i++) {
            right = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                int left;
                if (i - j >= 0) {
                    left = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    right = Math.min(right, left);
                }
            }
            dp[i] = right;
        }
        return dp[n - 1];
    }
}