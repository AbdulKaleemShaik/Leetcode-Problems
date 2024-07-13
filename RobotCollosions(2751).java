import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= positions.length; i++) {
            map.put(positions[i - 1], i);
        }
        Arrays.sort(positions);

        for (int i : positions) {
            int j = map.get(i);
            if (directions.charAt(j - 1) == 'R')
                st.add(j);
            else {
                while (!st.isEmpty() && healths[j - 1] > 0) {
                    int k = st.pop();
                    if (healths[j - 1] > healths[k - 1]) {
                        healths[k - 1] = 0;
                        healths[j - 1] -= 1;
                    } else if (healths[j - 1] < healths[k - 1]) {
                        healths[j - 1] = 0;
                        healths[k - 1] -= 1;
                        st.add(k);
                    } else {
                        healths[j - 1] = healths[k - 1] = 0;
                    }
                }
            }
        }
        for (int i : healths) {
            if (i > 0)
                ans.add(i);
        }
        return ans;

    }
}