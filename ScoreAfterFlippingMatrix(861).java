class Solution {
    public int matrixScore(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        // Flip Rows
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        // Flip Columns
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = 0; j < m; j++) {
                ones += grid[j][i];
            }
            if (ones < m - ones) {
                for (int k = 0; k < m; k++) {
                    grid[k][i] = 1 - grid[k][i];
                }
            }
        }

        // Sum Of Values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += grid[i][j] << (n - 1 - j);

            }
        }

        return res;
    }
}