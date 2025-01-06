import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int idx = 0;
        for (char i : boxes.toCharArray()) {
            if (!map.containsKey(i - '0')) {
                map.put(i - '0', new ArrayList<>());
                map.get(i - '0').add(idx++);
            } else {
                map.get(i - '0').add(idx++);
            }
        }
        if(!map.containsKey(1))return ans;
        for (int i = 0; i < boxes.length(); i++) {
            ans[i] = value(map.get(1), i);
        }
        return ans;
    }
    public  int value(List<Integer> li, int idx) {
        int val = 0;
        for (int i : li) {
            val += (Math.abs(idx - i));
        }
        return val;
    }
}