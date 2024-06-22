class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
         int ans = 0;
        int lower = 0, mid = 0;
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                odd++;
            while (odd > k) {
                if (nums[lower] % 2 == 1)
                    odd--;
                lower++;
                mid = lower;

            }

            if (odd == k) {
                while (nums[mid] % 2 != 1)
                    mid++;
                ans += (mid - lower + 1);
            }

        }
        return ans;
    }
}