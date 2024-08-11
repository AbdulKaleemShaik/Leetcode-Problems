class Solution {
    private int[] X = {-1, 0, 1, 0};
    private int[] Y = {0, 1, 0, -1};

    private boolean isBoundary(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ii = i + X[k];
            int jj = j + Y[k];
            if (isBoundary(ii, jj, grid.length, grid[0].length) 
                && grid[ii][jj] == 1 && !vis[ii][jj]) {
                dfs(ii, jj, grid, vis);
            }
        }
    }

    private int getIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length, cnt = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    cnt++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        return cnt;
    }

    public int minDays(int[][] grid) {
        if (getIslands(grid) != 1) return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (getIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}