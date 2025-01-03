class Solution {
    public int waysToSplitArray(int[] nums) {
        int ans = 0;
        long totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        long presum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            presum += nums[i];
            if (presum >= totalSum - presum)
                ans++;
        }
        return ans;
    }
}