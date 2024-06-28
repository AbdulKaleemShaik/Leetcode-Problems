import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    long ans = 0;

    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            gp.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            gp.get(roads[i][0]).add(roads[i][1]);
            gp.get(roads[i][1]).add(roads[i][0]);
        }
        int[] values = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> gp.get(b).size() - gp.get(a).size());
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        for (int i = n; i > 0; i--) {
            values[pq.poll()] = i;
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            findScore(values, gp, i, vis);
        }
        return ans;
    }

    public void findScore(int[] values, List<List<Integer>> gp, int node, boolean[] vis) {
        vis[node] = true;
        for (int i = 0; i < gp.get(node).size(); i++) {
            int nextnode = gp.get(node).get(i);
            if (!vis[nextnode])
                ans += values[node] + values[gp.get(node).get(i)];
        }

    }
}