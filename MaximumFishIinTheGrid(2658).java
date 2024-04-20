class Solution {
    int cnt = 0;

    public int findMaxFish(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    cnt = grid[i][j];
                    ans = Math.max(ans, findall(grid, i, j, m, n));
                    cnt = 0;
                }
            }
        }

        return ans;

    }

    public int findall(int[][] grid, int row, int col, int m, int n) {
        grid[row][col] = 0;
        int[] rows = { 1, -1, 0, 0 };
        int[] cols = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            if (row + rows[k] >= 0 && row + rows[k] < m && col + cols[k] >= 0 && col + cols[k] < n
                    && grid[row + rows[k]][col + cols[k]] != 0) {
                cnt += grid[row + rows[k]][col + cols[k]];
                findall(grid, row + rows[k], col + cols[k], m, n);

            }

        }
        return cnt;
    }
}