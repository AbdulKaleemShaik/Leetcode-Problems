class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int idx = 0;
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        k = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k)
                return i;
            k -= chalk[i];
        }
        return idx;
    }
}