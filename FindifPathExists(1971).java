import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
            gp.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == destination) {
                return true;
            }
            for (int i = 0; i < gp.get(curr).size(); i++) {
                if (!vis[gp.get(curr).get(i)]) {
                    vis[gp.get(curr).get(i)] = true;
                    q.add(gp.get(curr).get(i));
                }
            }
        }
        return false;
    }
}