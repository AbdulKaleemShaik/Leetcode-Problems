import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int count = 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int[] s = points[0];
        int end = s[1];
        for (int i = 1; i < points.length; i++) {
            if (end >= points[i][0]) {
                end = Math.min(end, points[i][1]);
                continue;
            } else {
                count++;
                end = points[i][1];
            }
        }
        return count + 1;
    }
}