import java.util.Arrays;

class Solution {
    public int maxTotalReward(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        System.out.println(dp);
        return find(arr, 0, 0, dp);
    }

    private int find(int[] arr, int i, int sum, int[] dp) {
        if (i >= arr.length) {
            return sum;
        }
        if (dp[sum] != -1) {
            return dp[sum];
        }
        int not_pick = find(arr, i + 1, sum, dp);
        int pick = 0;
        if (sum < arr[i]) {
            pick = find(arr, i + 1, sum + arr[i], dp);
        }
        return dp[sum] = Math.max(not_pick, pick);

    }
}