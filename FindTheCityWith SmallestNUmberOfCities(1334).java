class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> gp = new ArrayList<>();
        PriorityQueue<Pair> res = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            gp.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, 100000000);
            dist[i] = 0;
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(i, 0));
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                for (int j = 0; j < gp.get(p.src).size(); j++) {
                    int x = gp.get(p.src).get(j).src;
                    int y = gp.get(p.src).get(j).dest;
                    if (dist[x] > p.dest + y) {
                        dist[x] = p.dest + y;
                        pq.add(new Pair(x, dist[x]));
                    }
                }
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[j] <= distanceThreshold) {
                    cnt++;
                }
            }
            res.add(new Pair(i, cnt));
        }
      //  System.out.println(res);
        return res.peek().src;
    }
}
class Pair implements Comparable<Pair> {
    int src, dest;

    Pair(int i, int j) {
        this.src = i;
        this.dest = j;
    }

    public int compareTo(Pair comparedObj) {
        if (this.dest == comparedObj.dest)
            return comparedObj.src - this.src;
        return this.dest - comparedObj.dest;

    }
    public String toString(){
     return this.src+" "+this.dest;
    }
}