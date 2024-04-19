class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1) {
                    if (helpDFS(i, j, grid1, grid2)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean helpDFS(int i, int j, int[][] grid1, int[][] grid2) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length) {
            return true;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        if (grid2[i][j] == 1 && grid1[i][j] == 0) {
            return false;
        }
        grid2[i][j] = 0;
        boolean result = true;

        result &= helpDFS(i + 1, j, grid1, grid2);
        result &= helpDFS(i - 1, j, grid1, grid2);
        result &= helpDFS(i, j + 1, grid1, grid2);
        result &= helpDFS(i, j - 1, grid1, grid2);

        return result;
    }
}