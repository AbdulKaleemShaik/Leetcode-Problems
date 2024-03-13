class Solution {
    public int pivotInteger(int n) {
        int rightsum = 0;
        for (int i = 1; i <= n; i++) {
            rightsum += i;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;

            if (sum == rightsum) {
                return i;
            }
            rightsum = rightsum - i;

        }
        return -1;
    }
}