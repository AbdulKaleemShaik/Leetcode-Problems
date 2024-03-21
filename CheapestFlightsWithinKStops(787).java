import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       Queue<pair> q = new LinkedList<>();
       q.add(new pair(0, src, 0));
       ArrayList<ArrayList<tuple>> gp = new ArrayList<>();
       for (int i = 0; i < n; i++) {
           gp.add(new ArrayList<>());
       }
       for (int i = 0; i < flights.length; i++) {
           gp.get(flights[i][0]).add(new tuple(flights[i][1], flights[i][2]));
       }

       int[] dist = new int[n];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[src] = 0;
       while (!q.isEmpty()) {
           pair y = q.poll();
           int stops = y.stop;
           int node = y.node;
           int cost = y.cost;
           if (stops > k) {
               continue;
           }
           for (tuple iter : gp.get(node)) {
               int adjnode = iter.dest;
               int edn = iter.weight;
               if (cost + edn < dist[adjnode] && stops <= k) {
                   dist[adjnode] = cost + edn;
                   q.add(new pair(stops + 1, adjnode, cost + edn));
               }
           }

       }
       if (dist[dst] == Integer.MAX_VALUE) {
           return -1;
       }
       return dist[dst];
   }
}
class pair {
   int stop;
   int node;
   int cost;

   pair(int stop, int node, int cost) {
       this.stop = stop;
       this.node = node;
       this.cost = cost;
   }
}

class tuple {
   int dest, weight;

   tuple(int dest, int w) {
       this.dest = dest;
       this.weight = w;
   }
}