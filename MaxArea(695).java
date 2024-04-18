
class Solution {
    int count = 1;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int cnt = 0;
        int n = grid[0].length;
        boolean[][] br = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !br[i][j]) {
                    dfs(grid, i, j, m, n, br);
                    cnt = Math.max(count, cnt);
                    count = 1;
                }
            }
        }
        return cnt;

    }

    public void dfs(int[][] grid, int i, int j, int m, int n, boolean[][] vis) {
        vis[i][j] = true;

        int row[] = { 1, -1, 0, 0 };
        int col[] = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            if (check(i + row[k], j + col[k], m, n) && !vis[i + row[k]][j + col[k]]
                    && grid[i + row[k]][j + col[k]] == 1) {
                count++;
                dfs(grid, i + row[k], j + col[k], m, n, vis);

            }

        }

    }

    public static boolean check(int row, int col, int m, int n) {
        if (row >= 0 && row < m && col >= 0 && col < n) {
            return true;
        }
        return false;
    }

}