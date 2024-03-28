import java.util.Arrays;
import java.util.List;

class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return helper(dp, triangle, 0, 0);
    }

    public static int helper(int[][] dp, List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = triangle.get(i).get(j) + helper(dp, triangle, i + 1, j);
        int dia = triangle.get(i).get(j) + helper(dp, triangle, i + 1, j + 1);
        return dp[i][j] = Math.min(down, dia);

    }
}