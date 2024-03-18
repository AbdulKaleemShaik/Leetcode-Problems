import java.util.Arrays;

class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return helper(obstacleGrid, dp, 0, 0);
    }

    public static int helper(int[][] obstacleGrid, int[][] dp, int i, int j) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = helper(obstacleGrid, dp, i, j + 1);
        int right = helper(obstacleGrid, dp, i + 1, j);
        return dp[i][j] = left + right;
    }
}