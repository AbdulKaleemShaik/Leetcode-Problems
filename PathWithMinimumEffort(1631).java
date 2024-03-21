import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] is : dist) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.e - b.e);
        pq.add(new pair(0, 0, 0));
        int dis = 0;
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            dis = p.e;
            int i = p.i;
            int j = p.j;
            if (i == m - 1 && j == n - 1) {
                return dis;
            }
            int rows[] = { -1, 1, 0, 0 };
            int cols[] = { 0, 0, 1, -1 };
            for (int k = 0; k < 4; k++) {
                int cur = i + rows[k];
                int curr = j + cols[k];
                if (isvalid(cur, curr, m, n)) {
                    if (Math.max(dist[i][j], Math.abs(heights[cur][curr] - heights[i][j])) < dist[cur][curr]) {
                        dist[cur][curr] = Math.max(dist[i][j], Math.abs(heights[cur][curr] - heights[i][j]));
                        pq.add(new pair(Math.max(dist[i][j], Math.abs(heights[cur][curr] - heights[i][j])), cur, curr));
                    }
                }
            }
        }
        return dis;
    }

    public static boolean isvalid(int row, int col, int m, int n) {
        if (row >= 0 && row < m && col >= 0 && col < n) {
            return true;
        }
        return false;
    }
}

class pair {
    int e, i, j;

    pair(int e, int i, int j) {
        this.e = e;
        this.i = i;
        this.j = j;
    }
}