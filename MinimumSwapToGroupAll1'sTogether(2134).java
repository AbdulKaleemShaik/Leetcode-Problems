class Solution {
    public int minSwaps(int[] nums) {
         int total_ones = 0;
        int n = nums.length;
        for (int i : nums)
            total_ones += i;
        int curr_size = 0, max_size = 0, L = 0;
        for (int i = 0; i < 2 * nums.length; i++) {
            curr_size += nums[i % n];
            if (i - L + 1 > total_ones) {
                curr_size -= nums[L % n];
                L++;
            }
            max_size = Math.max(max_size, curr_size);
        }
        return total_ones - max_size;
    }
}