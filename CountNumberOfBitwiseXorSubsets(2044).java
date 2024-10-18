class Solution {
    int ans = 0;

    public int countMaxOrSubsets(int[] nums) {
        int maxXor = 0;
        for (int i : nums) {
            maxXor |= i;
        }
        findSubset(0, 0, maxXor, nums);
        return ans;
    }

    public void findSubset(int idx, int curXor, int maxXor, int[] nums) {
        if (idx == nums.length) {
            if (curXor == maxXor)
                ans++;
            return;
        }
        findSubset(idx + 1, curXor, maxXor, nums);
        findSubset(idx + 1, curXor | nums[idx], maxXor, nums);
    }
}