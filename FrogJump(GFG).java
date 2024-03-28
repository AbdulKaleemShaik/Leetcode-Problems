import java.util.*;
import java.io.*;

 class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(dp, heights, n - 1);
    }

    public static int helper(int[] dp, int[] arr, int idx) {
        if (idx == 0) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int left = helper(dp, arr, idx - 1) + Math.abs(arr[idx] - arr[idx - 1]);
        int right = Integer.MAX_VALUE;
        if (idx > 1) {
            right = helper(dp, arr, idx - 2) + Math.abs(arr[idx] - arr[idx - 2]);
        }
        dp[idx] = Math.min(left, right);
        return dp[idx];
    }

}