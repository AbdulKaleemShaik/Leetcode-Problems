class Solution {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (target != 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target = target / 2;
                ans++;
                maxDoubles--;

            } else if (maxDoubles == 0) {
                return ans + (target - 1);
            } else {
                target = target - 1;
                ans++;
            }
        }
        return ans;
    }
}