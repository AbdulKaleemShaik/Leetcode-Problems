class Solution {
    public long countSubarrays(int[] nums, int k) {
        long cnt = 0;
        int start = 0;
        int max = 0;
        for (int l = 0; l < nums.length; l++) {
            max = Math.max(max, nums[l]);
        }
        int maxfreq = 0;
        for (int l : nums) {
            if (l == max) {
                maxfreq++;
            }
            while (maxfreq == k) {
                if (nums[start] == max) {
                    maxfreq--;
                }
                start++;
            }
            cnt += start;
        }
        return cnt;
    }
}