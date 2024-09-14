class Solution {
    public int longestSubarray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        for (int i : nums) {
            maxi = Math.max(maxi, i);
        }
        int ans = 0, cnt = 0;
        for (int i : nums) {
            if (i == maxi)
                cnt++;
            else {
                cnt = 0;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}