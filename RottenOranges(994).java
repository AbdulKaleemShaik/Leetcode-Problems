import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new pair(i, j, 0));
                }
            }
        }
        pair p = new pair(0, 0, 0);
        while (!q.isEmpty()) {
            p = q.poll();
            int row = p.i;
            int col = p.j;
            int time = p.t;
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                q.add(new pair(row - 1, col, time + 1));
                grid[row - 1][col] = 2;
            }
            if (row + 1 < grid.length && grid[row + 1][col] == 1) {
                q.add(new pair(row + 1, col, time + 1));
                grid[row + 1][col] = 2;
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                q.add(new pair(row, col - 1, time + 1));
                grid[row][col - 1] = 2;
            }
            if (col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                q.add(new pair(row, col + 1, time + 1));
                grid[row][col + 1] = 2;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return p.t;
    }
}

class pair {
    int i, j, t;

    pair(int row, int col, int time) {
        this.i = row;
        this.j = col;
        this.t = time;
    }
}