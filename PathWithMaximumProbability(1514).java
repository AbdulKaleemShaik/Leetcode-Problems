import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double ans = 0;
        List<List<Pair>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            gp.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            gp.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.weight, a.weight));
        pq.add(new Pair(start_node, 1));
        Pair curr = null;
        boolean[] vis = new boolean[n];
        while (!pq.isEmpty()) {
            curr = pq.poll();
            if (curr.node == end_node && ans < curr.weight) {
                ans = curr.weight;
                break;
            }
            double wg = curr.weight;
            if (vis[curr.node])
                continue;
            vis[curr.node] = true;
            for (Pair i : gp.get(curr.node)) {
                pq.add(new Pair(i.node, wg * i.weight));
            }
        }

        return ans;
    }
}

class Pair {
    int node;
    double weight;

    Pair(int i, double j) {
        this.node = i;
        this.weight = j;
    }
}

class Solutio {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
         double[] maxProbArray = new double[n];
        maxProbArray[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
               
                double currProb = succProb[j];

                int u = edges[j][0];
                int v = edges[j][1];
                if (maxProbArray[v] * currProb > maxProbArray[u]) {
                    maxProbArray[u] = maxProbArray[v] * currProb;
                    updated = true;
                }
                if (maxProbArray[u] * currProb > maxProbArray[v]) {
                    maxProbArray[v] = maxProbArray[u] * currProb;
                    updated = true;
                }
            }
            if (!updated)
                break;
        }

        return maxProbArray[end_node];
    }
}