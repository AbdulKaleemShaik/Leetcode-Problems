class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
         int n = rowSum.length;
        int m=colSum.length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = val;
                rowSum[i] -= val;
                colSum[j] -= val;
            }
        }
        // for (int[] is : ans) {
        //     System.out.println(Arrays.toString(is));
        // }
        return ans;
    }
}