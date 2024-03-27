import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        int[] dist = new int[n];
        for (int i = 0; i < m; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
            gp.get(edges[i][1]).add(edges[i][0]);
        }
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(src, 0));
        while (!q.isEmpty()) {
            int node = q.peek().node;
            int cost = q.peek().val;
            q.poll();
            for (int i = 0; i < gp.get(node).size(); i++) {
                int adj = gp.get(node).get(i);
                if (cost + 1 < dist[adj]) {
                    dist[adj] = cost + 1;
                    q.add(new pair(adj, cost + 1));
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}

class pair {
    int node, val;

    pair(int i, int j) {
        this.node = i;
        this.val = j;
    }
}