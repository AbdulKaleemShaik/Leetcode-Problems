import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int dp2[] = new int[nums.length];
        Arrays.fill(dp2, -1);
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = nums[i + 1];
        }
        for (int i = 0; i < n - 1; i++) {
            arr2[i] = nums[i];
        }
        int ans1 = helper(dp, arr1.length - 1, arr1);
        int ans2 = helper(dp2, arr2.length - 1, arr2);
        return Math.max(ans1, ans2);
    }

    public int f(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int notpick = 0 + prev;
            int curr = Math.max(pick, notpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
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