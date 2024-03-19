import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static boolean isvalid(int row, int col, int m, int n) {
        if (row >= 0 && row < m && col >= 0 && col < n) {
            return true;
        }
        return false;
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] is : dist) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<pair> qe = new LinkedList<pair>();
        qe.add(new pair(0, 0, 0));
        while (!qe.isEmpty()) {
            pair p = qe.poll();
            if (p.i == m - 1 && p.j == n - 1) {
                return p.w + 1;
            }
            int r = p.i;
            int c = p.j;
            for (int i = 0; i < 8; i++) {
                int rows[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
                int cols[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
                if (isvalid(r + rows[i], c + cols[i], m, n) && grid[r + rows[i]][c + cols[i]] != 1) {
                    if (dist[r][c] + p.w < dist[r + rows[i]][c + cols[i]]) {
                        dist[r + rows[i]][c + cols[i]] = p.w + 1;
                        qe.add(new pair(dist[r + rows[i]][c + cols[i]], r + rows[i], c + cols[i]));
                    }
                }

            }
        }
        return -1;
    }
}

class pair {
    int w, i, j;

    pair(int w, int i, int j) {
        this.w = w;
        this.i = i;
        this.j = j;
    }
}