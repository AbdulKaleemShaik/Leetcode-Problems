class Solution {
    public int strangePrinter(String s) {
       int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int j = n - 1; j >= 0; j--) {
            for (int k = j; k < n; k++) {
                int ans = 1 + dp[j + 1][k];
                for (int i = j + 1; i <= k; i++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        ans = Math.min(ans, dp[j][i - 1] + dp[i + 1][k]);
                    }
                }
                dp[j][k] = ans;
            }
        }

        return dp[0][n - 1]; 
    }
}