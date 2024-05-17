import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans = 0;
        int n = points.length;
        List<pair>[] gp = new List[n];
        for (int i = 0; i < n; i++) {
            gp[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                gp[i].add(new pair(j, findDistance(points[i][0], points[i][1], points[j][0], points[j][1])));
            }
        }
        boolean[] vis = new boolean[n];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new pair(0, 0));
        while (!pq.isEmpty()) {
            int currNode = pq.peek().node;
            int currDis = pq.peek().dist;
            pq.poll();
            if (vis[currNode])
                continue;
            ans += currDis;
            vis[currNode] = true;
            for (int i = 0; i < gp[currNode].size(); i++) {
                pair nod = gp[currNode].get(i);
                pq.add(new pair(nod.node, nod.dist));
            }
        }
        return ans;
    }

    public int findDistance(int i, int j, int k, int l) {
        return Math.abs(i - k) + Math.abs(j - l);
    }
}

class pair {
    int node, dist;

    pair(int i, int j) {
        this.node = i;
        this.dist = j;
    }
}