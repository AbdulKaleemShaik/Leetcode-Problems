class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len = 0;
        int i = 0;
        int num = 0;
        for (int j = 0; j < nums.length; j++) {
            while ((num & nums[j]) != 0) {
                num ^= nums[i++];
            }
            num |= nums[j];
            len = Math.max(len, j - i + 1);
        }
        return len;
    }
}