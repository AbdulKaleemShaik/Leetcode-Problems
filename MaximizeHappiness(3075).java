import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long maxihappi = 0;
        Arrays.sort(happiness);
        int j = happiness.length - 1;
        for (int i = 0; i < k; i++) {
            if (happiness[j] - i > 0) {
                maxihappi += (happiness[j] - i);
                j--;
            }
        }
        return maxihappi;
    }
}