class Solution {
    public int passThePillow(int n, int time) {
        int direction = time / (n - 1);
        int remaining = time % (n - 1);
        int ans = 0;
        if (direction % 2 != 0) {
            ans = n - remaining;
        } else {
            ans = remaining + 1;
        }
        return ans;
    }
}