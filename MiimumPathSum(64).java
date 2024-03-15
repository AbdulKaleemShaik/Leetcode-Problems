class Solution {
    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        return helper(dp, 0, 0, m, n, grid);
    }

    public static int helper(int[][] dp, int row, int col, int m, int n, int[][] grid) {
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int left = helper(dp, row, col + 1, m, n, grid);
        int down = helper(dp, row + 1, col, m, n, grid);
        dp[row][col] = grid[row][col] + Math.min(left, down);
        return dp[row][col];
    }
}