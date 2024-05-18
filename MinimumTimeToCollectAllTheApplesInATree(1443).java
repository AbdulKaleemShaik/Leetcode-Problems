import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int time = 0;
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
            gp.get(edges[i][1]).add(edges[i][0]);
        }
        time = dfs(0, -1, gp, hasApple);
        return time;
    }

    public static int dfs(int curr, int parent, List<List<Integer>> gp, List<Boolean> hasApple) {
        int time = 0;
        for (int i : gp.get(curr)) {
            if (i == parent)
                continue;
            int ChildTime = 0;
            ChildTime += dfs(i, curr, gp, hasApple);
            if (ChildTime > 0 || hasApple.get(i)) {
                time += 2 + ChildTime;
            }
        }
        return time;
    }

}