class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
       int[] ans = new int[queries.length];
        int[] preQuery = new int[arr.length];
        preQuery[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preQuery[i] = arr[i] ^ preQuery[i - 1];
        }
       // System.out.println(Arrays.toString(preQuery));

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u != 0) {
                ans[i] = preQuery[u - 1] ^ preQuery[v];
            } else {
                ans[i] = preQuery[v];
            }
        }
      //  System.out.println(Arrays.toString(ans));
        return ans; 
    }
}