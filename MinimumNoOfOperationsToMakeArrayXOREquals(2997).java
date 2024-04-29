class Solution {
    public int minOperations(int[] nums, int k) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        if (ans == k) {
            return 0;
        }
        ans = findXor(ans, k, 0);
        return ans;
    }

    public int findXor(int i, int j, int ans) {
        for (int k = 0; k < 31; k++) {
            if ((i & 1) != (j & 1)) {
                ans++;
            }
            i >>= 1;
            j >>= 1;
        }
        return ans;
    }
}