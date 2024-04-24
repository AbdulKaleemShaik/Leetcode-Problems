class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev2 = 0, prev1 = 1, prev0 = 1;
        for (int i = 3; i <= n; i++) {
            int curr = prev2 + prev1 + prev0;
            prev2 = prev1;
            prev1 = prev0;
            prev0 = curr;
        }
        return prev0;
    }
}