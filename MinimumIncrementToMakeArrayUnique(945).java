class Solution {
    public int minIncrementForUnique(int[] nums) {

        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i : nums)
            max = Math.max(i, max);
        int[] count = new int[nums.length + max];
        for (int i : nums) {
            count[i]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] <= 1)
                continue;
            int extra = count[i] - 1;
            count[i + 1] += extra;
            ans += extra;
        }
        return ans;
    }
}