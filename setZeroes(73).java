import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<pair> qr = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    qr.add(new pair(i, j));
                }
            }
        }
        pair p = new pair(0, 0);
        while (!qr.isEmpty()) {
            p = qr.poll();
            int row = p.i;
            int col = p.j;
            int k = row;
            int l = col;
            while (k >= 0) {
                matrix[k][l] = 0;
                k--;
            }
            k = row;
            l = col;
            while (k < m) {
                matrix[k][l] = 0;
                k++;
            }
            k = row;
            l = col;
            while (l >= 0) {
                matrix[k][l] = 0;
                l--;
            }
            k = row;
            l = col;
            while (l < n) {
                matrix[k][l] = 0;
                l++;
            }

        }

    }
}

class pair {
    int i, j;

    pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}