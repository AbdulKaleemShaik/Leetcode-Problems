import java.util.List;
import java.util.ArrayList;

import java.util.PriorityQueue;
 class Solution {
     public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<pair>[] gp = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            gp[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            gp[edge[i][0]].add(new pair(edge[i][1], edge[i][2]));
            gp[edge[i][1]].add(new pair(edge[i][0], edge[i][2]));
        }
        int[] dis = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[source] = 0;
        graph(gp, source, dis);
        for (int i : dis) {
            ans.add(i);
        }
        return ans;

    }

    public static void graph(ArrayList<pair>[] gp, int node, int[] dis) {

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new pair(node, 0));
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            for (int k = 0; k < gp[p.node].size(); k++) {
                pair pt = gp[p.node].get(k);
                if (dis[p.node] + pt.weight < dis[pt.node]) {
                    dis[pt.node] = dis[p.node] + pt.weight;
                    pq.add(new pair(pt.node, dis[pt.node]));

                }

            }

        }
    }
}
class pair {
    int node, weight;

    pair(int i, int j) {
        this.node = i;
        this.weight = j;
    }

}
