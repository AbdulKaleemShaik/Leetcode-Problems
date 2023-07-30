class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int e = nums.length - 1;
        int[] result = new int[nums.length];
        if (nums.length == 0) {
            return new int[0];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int start = nums[l] * nums[l];
            int end = nums[e] * nums[e];
            if (end > start) {
                result[i] = end;
                e--;
            } else {
                result[i] = start;
                l++;
            }

        }
        return result;
    }
}