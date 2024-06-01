class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] box = new int[46];
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int n = i, sum = 0;
            while (n > 0) {
                sum += n % 10;
                n = n / 10;
            }
            ans = Math.max(ans, ++box[sum]);
        }
        return ans;
    }
}