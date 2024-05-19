import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = cost.length;

        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
            gp.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        long[] ans = new long[n];
        Arrays.fill(ans, 0l);
        dfs(gp, cost, ans, 0, visited);
        return ans;
    }

    public List<Integer> dfs(List<List<Integer>> map, int[] cost, long[] ans, int curr, boolean[] visited) {

        visited[curr] = true;

        List<Integer> temp = new ArrayList<>();
        for (int adj : map.get(curr)) {
            if (!visited[adj])
                temp.addAll(dfs(map, cost, ans, adj, visited));
        }
        temp.add(cost[curr]);
        Collections.sort(temp);

        int n = temp.size();
        if (n >= 3) {

            long left = (long) temp.get(0) * temp.get(1);
            long right = (long) temp.get(n - 3) * temp.get(n - 2);
            ans[curr] = Math.max(0, Math.max(left, right) * temp.get(n - 1));
        } else {
            ans[curr] = 1;
        }

        if (n <= 5)
            return temp;

        return new ArrayList<>(
                Arrays.asList(temp.get(0), temp.get(1), temp.get(n - 3), temp.get(n - 2), temp.get(n - 1)));
    }

}