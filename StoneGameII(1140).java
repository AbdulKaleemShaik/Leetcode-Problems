class Solution {
    public int stoneGameII(int[] piles) {
       int n = piles.length;
       int[] suffixSum = new int[n];
       suffixSum[n - 1] = piles[n - 1];

       for (int i = n - 2; i >= 0; i--) {
           suffixSum[i] = piles[i] + suffixSum[i + 1];
       }

       int[][] dp = new int[n][n];

       return helper(0, 1, piles, dp, suffixSum);
   }

   private int helper(int i, int M, int[] piles, int[][] dp, int[] suffixSum) {
       int n = piles.length;

       if (i == n)
           return 0;

       int boundedM = Math.min(M, n - 1);

       if (dp[i][boundedM] != 0)
           return dp[i][boundedM];

       if (2 * M >= n - i)
           return suffixSum[i];

       int minStones = Integer.MAX_VALUE;

       for (int X = 1; X <= 2 * M && i + X <= n; X++) {
           minStones = Math.min(minStones, helper(i + X, Math.max(M, X), piles, dp, suffixSum));
       }

       dp[i][boundedM] = suffixSum[i] - minStones;

       return dp[i][boundedM];
   }
}