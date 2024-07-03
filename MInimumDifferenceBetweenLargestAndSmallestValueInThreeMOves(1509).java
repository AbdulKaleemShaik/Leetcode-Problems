class Solution {
    public int minDifference(int[] nums) {
        int ans = Integer.MAX_VALUE;
        if (nums.length <= 4)
            return 0;
        Arrays.sort(nums);
        int j = nums.length - 4;
        for (int i = 0; i < 4; i++) {
            ans = Math.min(ans, nums[j++] - nums[i]);
        }
        return ans;
    }
}