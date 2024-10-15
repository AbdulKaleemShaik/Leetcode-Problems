class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        int l = 0, r = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                ans += r - l;
                l++;
            }
            r++;
        }
        return ans;
    }
}