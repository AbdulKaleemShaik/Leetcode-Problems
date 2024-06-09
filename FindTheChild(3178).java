class Solution {
    public int numberOfChild(int n, int k) {
        int ans = 0;
        int i = 0;
        while (i <= k) {
            while (ans < n - 1) {
                if (i == k)
                    return ans;
                ans++;
                i++;
            }
            while (ans > 0) {
                if (i == k)
                    return ans;
                ans--;
                i++;
            }
        }
        return ans;
    }
}