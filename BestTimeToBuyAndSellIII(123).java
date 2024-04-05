class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }
        return helper(0, 1, 2, dp, prices);
    }

    public static int helper(int idx, int buy, int cap, int[][][] dp, int[] arr) {

        if (cap == 0) {
            return 0;
        }
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx][buy][cap] != -1) {
            return dp[idx][buy][cap];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-arr[idx] + helper(idx + 1, 0, cap, dp, arr), 0 + helper(idx + 1, 1, cap, dp, arr));
        } else {
            profit = Math.max(arr[idx] + helper(idx + 1, 1, cap - 1, dp, arr), 0 + helper(idx + 1, 0, cap, dp, arr));
        }
        return dp[idx][buy][cap] = profit;
    }

}