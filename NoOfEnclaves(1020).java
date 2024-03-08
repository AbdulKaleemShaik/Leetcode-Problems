class Solution {
    public static int numEnclaves(int[][] b) {
        int m = b.length;
        int n = b[0].length;
        boolean[][] br = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            if (!br[0][i]) {
                if (b[0][i] == 1) {
                    dfs(b, br, 0, i);
                }
            }
            if (!br[m - 1][i]) {
                if (b[m - 1][i] == 1) {
                    dfs(b, br, m - 1, i);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (!br[i][0]) {
                if (b[i][0] == 1) {
                    dfs(b, br, i, 0);
                }
            }
            if (!br[i][n - 1]) {
                if (b[i][n - 1] == 1) {

                    dfs(b, br, i, n - 1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!br[i][j] && b[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int[][] b, boolean[][] br, int row, int col) {
        br[row][col] = true;
        int m = b.length;
        int n = b[0].length;
        if (row - 1 >= 0 && b[row - 1][col] == 1 && !br[row - 1][col]) {
            dfs(b, br, row - 1, col);
        }
        if (row + 1 < m && b[row + 1][col] == 1 && !br[row + 1][col]) {
            dfs(b, br, row + 1, col);
        }
        if (col - 1 >= 0 && b[row][col - 1] == 1 && !br[row][col - 1]) {
            dfs(b, br, row, col - 1);
        }
        if (col + 1 < n && b[row][col + 1] == 1 && !br[row][col + 1]) {
            dfs(b, br, row, col + 1);
        }
    }
}