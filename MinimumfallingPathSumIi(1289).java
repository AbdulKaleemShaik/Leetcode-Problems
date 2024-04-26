import java.util.Arrays;

public class MinimumFallingSum {

    public int solve(int r, int c, int[][] grid, int[][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        if (r < 0 || r >= n || c < 0 || c >= m)
            return Integer.MAX_VALUE;

        if (r == n - 1)
            return grid[r][c];

        if (dp[r][c] != -1)
            return dp[r][c];

        int sum = grid[r][c];
        int p = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            if (j != c) {
                int temp = solve(r + 1, j, grid, dp);
                p = Math.min(p, temp);
            }
        }
        sum += p;
        return dp[r][c] = sum;
    }

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, solve(0, i, grid, dp));
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumFallingSum mr = new MinimumFallingSum();
        System.out.println(mr.minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
    }
}
