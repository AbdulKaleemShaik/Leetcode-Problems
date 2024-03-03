class Solution {
    int n, m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int i, int j, char[][] grid) {
        grid[i][j] = '2';
        if (i > 0 && grid[i - 1][j] == '1')
            bfs(i - 1, j, grid);
        if (i < n - 1 && grid[i + 1][j] == '1')
            bfs(i + 1, j, grid);
        if (j > 0 && grid[i][j - 1] == '1')
            bfs(i, j - 1, grid);
        if (j < m - 1 && grid[i][j + 1] == '1')
            bfs(i, j + 1, grid);

    }
}
