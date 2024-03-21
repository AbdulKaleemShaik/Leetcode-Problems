import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Long.compare(x.first, y.first));
        long dist[] = new long[n];
        long ways[] = new long[n];
        for (int i = 0; i < n; i++)
            dist[i] = Long.MAX_VALUE;
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));
        long mod = (int) (1e9 + 7);
        while (pq.size() != 0) {
            long dis = pq.peek().first;
            long node = pq.peek().second;
            pq.remove();
            for (Pair it : adj.get((int) node)) {
                long adjNode = it.first;
                long ew = it.second;
                if (dis + ew < dist[(int) adjNode]) {
                    dist[(int) adjNode] = dis + ew;
                    pq.add(new Pair(dis + ew, adjNode));
                    ways[(int) adjNode] = ways[(int) node];
                } else if (dis + ew == dist[(int) adjNode]) {
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) node]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);

    }
}