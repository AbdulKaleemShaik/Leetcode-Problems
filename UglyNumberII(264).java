class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int l = 1; l < n; l++) {
            int curr_num = Math.min(nums[i] * 2, Math.min(nums[j] * 3, nums[k] * 5));
            nums[l] = curr_num;
            if (curr_num == nums[i] * 2)
                i++;
            if (curr_num == nums[j] * 3)
                j++;

            if (curr_num == nums[k] * 5)
                k++;
        }
        return nums[n - 1];

    }
}