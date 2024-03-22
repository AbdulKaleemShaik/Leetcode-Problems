import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] matrix, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int[] is : dist) {
            Arrays.fill(is, -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            dist[matrix[i][0]][matrix[i][1]] = matrix[i][2];
            dist[matrix[i][1]][matrix[i][0]] = matrix[i][2];
        }
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (dist[i][j] == -1) {
                    dist[i][j] = (int) (1e9);
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                for (int k = 0; k < dist[j].length; k++) {
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                if (dist[i][j] <= distanceThreshold && dist[i][j] != 0) {
                    ans[i]++;
                }
            }
        }

        int max = Arrays.stream(ans).min().orElse(0);
        int idx = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == max) {
                idx = i;
            }
        }
        return idx;
    }
}