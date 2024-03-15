import java.util.Arrays;

class Solution {
    public static int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int[] is : dp)
            Arrays.fill(is, -1);
        helper(dp, m, n, 0, 0);
        return dp[0][0];
    }

    public static int helper(int[][] dp, int m, int n, int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        if (row >= m || col >= n) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int left = helper(dp, m, n, row, col + 1);
        int right = helper(dp, m, n, row + 1, col);
        dp[row][col] = left + right;
        return left + right;
    }

}