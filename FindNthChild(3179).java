class Solution {
    public int valueAfterKSeconds(int n, int k) {
        final int M = (int) 1e9 + 7;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < k; i++) {
            int preSum = 1;
            for (int j = 1; j < ans.length; j++) {
                preSum = (preSum + ans[j]) % M;
                ans[j] = preSum % M;
            }
        }
        return ans[ans.length - 1] % M;
    }
}