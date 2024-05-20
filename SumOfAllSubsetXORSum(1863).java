class Solution {
    int ans = 0;

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, ans);
        return ans;
    }

    private void dfs(int[] nums, int i, int j) {
        if (i >= nums.length)
            return;
        for (int k = i; k < nums.length; k++) {
            int currentSum = j ^ nums[k];
            ans += currentSum;
            dfs(nums, k + 1, currentSum);
        }

    }
}