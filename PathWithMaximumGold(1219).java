class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( grid[i][j] != 0) {
                    ans = Math.max(ans, find(grid, i, j, m, n, vis));
                }
            }
        }
        return ans;
    }

    public int find(int[][] grid, int i, int j, int m, int n, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;
        int res = grid[i][j];
        int[] rows = { 1, -1, 0, 0 };
        int[] cols = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            res = Math.max(res, grid[i][j] + find(grid, i + rows[k], j + cols[k], m, n, vis));
        }
        vis[i][j] = false;
        return res;

    }
}