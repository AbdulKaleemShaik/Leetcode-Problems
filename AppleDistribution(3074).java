import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int minbox = 0;
        Arrays.sort(capacity);
        int sum = 0;
        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }
        for (int i = capacity.length - 1; i >= 0; i--) {
            if (capacity[i] < sum) {
                sum -= capacity[i];
                minbox++;
                continue;
            }
            break;
        }
        return minbox+1;
    }
}