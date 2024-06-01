import java.util.HashMap;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> colorApplied = new HashMap<>();
        HashMap<Integer, Integer> colorAppliedTo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (colorAppliedTo.containsKey(x)) {
                colorApplied.put(colorAppliedTo.get(x), colorApplied.get(colorAppliedTo.get(x)) - 1);
                if (colorApplied.get(colorAppliedTo.get(x)) == 0)
                    colorApplied.remove(colorAppliedTo.get(x));
            }
            colorAppliedTo.put(x, y);
            colorApplied.put(y, colorApplied.getOrDefault(y, 0) + 1);
            ans[i] = colorApplied.size();
        }
        return ans;
    }
}