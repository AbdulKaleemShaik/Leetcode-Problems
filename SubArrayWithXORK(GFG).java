
import java.util.*;

class Solution {
    public static int subarraysWithSumK(int[] A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            sum ^= A[i];
            if (map.containsKey(sum ^ B)) {
                count += map.get(sum ^ B);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}