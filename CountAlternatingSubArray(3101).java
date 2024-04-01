class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long[] dp = new long[nums.length];
        dp[0] = 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                dp[i] = dp[i - 1] + j + 1;
                j++;
            } else {
                dp[i] = dp[i - 1] + 1;
                j = 1;
            }
        }
        return dp[nums.length - 1];
    }
}