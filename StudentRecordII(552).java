class Solution {
    final int M = 1000000007;

    public long checkRecord(int n, int absentDaysLeft, int lateDaysleft, long[][][] dp) {
        if (n == 0)
            return 1;
        if (dp[n][absentDaysLeft][lateDaysleft] != -1)
            return dp[n][absentDaysLeft][lateDaysleft];
        long ans = 0;
        if (absentDaysLeft >= 1) {
            ans += (checkRecord(n - 1, absentDaysLeft - 1, 2, dp) % M);
        }
        if (lateDaysleft >= 1) {
            ans += (checkRecord(n - 1, absentDaysLeft, lateDaysleft - 1, dp) % M);
        }
        ans += (checkRecord(n - 1, absentDaysLeft, 2, dp) % M);
        ans %= M;
        return dp[n][absentDaysLeft][lateDaysleft] = ans;

    }

    public int checkRecord(int n) {
        long[][][] dp = new long[n + 1][2][3];

        for (long[][] i : dp)
            for (long[] j : i)
                Arrays.fill(j, -1);

        return (int) checkRecord(n, 1, 2, dp);
    }

}