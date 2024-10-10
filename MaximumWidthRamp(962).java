class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        int maxRight[] = new int[nums.length];
        int prevMAx = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            maxRight[i] = Math.max(prevMAx, nums[i]);
            prevMAx = Math.max(prevMAx, nums[i]);
        }
        int left = 0, right = 0;
        for (right = 0; right < nums.length; right++) {
            while (nums[left] > maxRight[right]) {
                left += 1;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}