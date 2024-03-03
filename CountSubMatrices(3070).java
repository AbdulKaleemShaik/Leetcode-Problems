class Solution {
    public int countSubmatrices(int[][] matrix, int x) {
        int ans = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < c; i++) {
            int sum = 0;
            for (int j = 0; j < r; j++) {
                sum += matrix[j][i];
                if (sum <= x) {
                    ans++;
                }
            }
        }

        return ans;
    }
}