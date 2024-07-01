class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int i : arr) {
            if ((1 & i) == 0) {
                cnt = 0;
                continue;
            }
            cnt++;
            if (cnt == 3)
                return true;
        }
        return false;
    }
}