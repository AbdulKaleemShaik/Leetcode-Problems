import java.util.*;

class Solution {
    public static int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(dp, nums.length - 1, nums);
    }

    public static int helper(int[] dp, int n, int[] nums) {
        if (n == 0) {
            return nums[0];
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int pick = nums[n] + helper(dp, n - 2, nums);
        int notpick = helper(dp, n - 1, nums);
        return dp[n] = Math.max(pick, notpick);
    }
}