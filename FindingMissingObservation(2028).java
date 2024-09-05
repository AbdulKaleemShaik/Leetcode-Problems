import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int remainingSum = 0;
        int arrSum = 0;
        for (int i : rolls) {
            arrSum += i;
        }
        remainingSum = (mean * (n + rolls.length) - arrSum);
        if (remainingSum > n * 6 || remainingSum < 0 || remainingSum < n) {
            return new int[] {};
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        remainingSum -= n;
        int idx = 0;
        while (remainingSum != 0) {
            if (remainingSum + ans[idx] <= 6) {
                ans[idx] = ans[idx] + remainingSum;
                remainingSum = 0;
            } else {
                int shouldAdd = 6 - ans[idx];
                ans[idx] = ans[idx] + shouldAdd;
                remainingSum -= shouldAdd;
                idx++;
            }
            // System.out.println(Arrays.toString(ans));
        }
        return ans;
    }
}