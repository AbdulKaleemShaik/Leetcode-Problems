import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxX = 0;
    int maxY = 0;

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    maxX = i;
                    maxY = j;
                    findall(land, i, j, m, n);
                    li.add(maxX);
                    li.add(maxY);
                    ans.add(li);

                }
            }
        }
        int[][] array = ans.stream()
                .map(innerList -> innerList.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        return array;
    }

    public void findall(int[][] grid, int row, int col, int m, int n) {
        grid[row][col] = 0;
        int[] rows = { 1, -1, 0, 0 };
        int[] cols = { 0, 0, 1, -1 };
        for (int k = 0; k < 4; k++) {
            if (row + rows[k] >= 0 && row + rows[k] < m && col + cols[k] >= 0 && col + cols[k] < n
                    && grid[row + rows[k]][col + cols[k]] == 1) {
                maxX = Math.max(maxX, row + rows[k]);
                maxY = Math.max(maxY, col + cols[k]);
                findall(grid, row + rows[k], col + cols[k], m, n);

            }

        }
    }
}
