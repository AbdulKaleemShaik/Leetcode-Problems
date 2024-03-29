import java.util.Arrays;

class Solution {
    public int coinChange(int[] arr, int T) {
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        int ans = minimumElementsUtil(arr, n - 1, T, dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    static int minimumElementsUtil(int[] arr, int ind, int T, int[][] dp) {
        if (ind == 0) {
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                return (int) Math.pow(10, 9);
        }
        if (dp[ind][T] != -1)
            return dp[ind][T];
        int notTaken = 0 + minimumElementsUtil(arr, ind - 1, T, dp);
        int taken = (int) Math.pow(10, 9);
        if (arr[ind] <= T)
            taken = 1 + minimumElementsUtil(arr, ind, T - arr[ind], dp);
        return dp[ind][T] = Math.min(notTaken, taken);
    }
}