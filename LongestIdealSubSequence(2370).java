import java.util.Arrays;

class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(s.charAt(i) - s.charAt(j)) <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
        // int[] dp = new int[26];
        // int ans = 0;
        // for (int i = 0; i < s.length(); i++) {
        // int element = s.charAt(i) - 'a';

        // for (int j = element; j >= 0 && j >= element - k; j--) {
        // if (j == element && dp[j] == 0) {
        // dp[j] = 1;
        // ans = Math.max(ans, dp[element]);
        // continue;
        // }
        // dp[element] = Math.max(dp[element], dp[j] + 1);
        // }
        // for (int j = element + 1; j < 26 && j <= element + k; j++) {
        // dp[element] = Math.max(dp[element], dp[j] + 1);
        // }
        // ans = Math.max(ans, dp[element]);
        // }
        // return ans;
    }
}