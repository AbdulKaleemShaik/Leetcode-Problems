class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        Set<Integer> st = new HashSet<>();
        int[] rowDir = { 0, 1, 0, -1 };
        int[] colDir = { 1, 0, -1, 0 };
        int dir = 0;
        int steps = 1;
        int idx = 0;
        while (idx < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    if (isValid(rows, cols, rStart, cStart)) {
                        ans[idx][0] = rStart;
                        ans[idx++][1] = cStart;
                    }
                    rStart += rowDir[dir];
                    cStart += colDir[dir];
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }
        // for (int[] i : ans) {
        //     System.out.println(Arrays.toString(i));

        // }
        return ans;
    }

    public boolean isValid(int m, int n, int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

}