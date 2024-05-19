import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            ans += nums[i];
        }
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            xor[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(xor);
        for (int i = xor.length - 1; i >= 1; i -= 2) {
            int sum = 0;
            sum = xor[i] + xor[i - 1];
            if (sum < 0) {
                break;
            }
            ans += sum;
        }
        return ans;
    }
}