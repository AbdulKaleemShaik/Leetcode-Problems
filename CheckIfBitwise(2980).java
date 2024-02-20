class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int ans;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = nums[i] | nums[j];
                if ((k & 1) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}