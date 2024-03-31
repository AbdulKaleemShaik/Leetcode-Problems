class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i = -1, j = -1, k = -1;
        long cnt = 0;
        for (int l = 0; l < nums.length; l++) {
            if (nums[l] < minK || nums[l] > maxK)
                k = l;
            if (nums[l] == minK)
                i = l;
            if (nums[l] == maxK)
                j = l;
            cnt += Math.max(0, Math.min(i, j) - k);
        }
        return cnt;
    }
}