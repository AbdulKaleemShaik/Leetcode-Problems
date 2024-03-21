import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(k, 0));
        ArrayList<ArrayList<tuple>> gp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            gp.get(times[i][0]).add(new tuple(times[i][1], times[i][2]));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;
        while (!q.isEmpty()) {
            tuple t = q.poll();
            int curr = t.dest;
            int w = t.weight;
            for (tuple iter : gp.get(curr)) {
                int adjnode = iter.dest;
                int c = iter.weight;
                if (w + c < dist[adjnode]) {
                    dist[adjnode] = w + c;
                    q.add(new tuple(adjnode, c + w));
                }
            }

        }
        int max = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
class tuple {
    int dest, weight;

    tuple(int dest, int w) {
        this.dest = dest;
        this.weight = w;
    }
}