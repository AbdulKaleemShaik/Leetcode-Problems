class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            gp.get(u).add(v);
            gp.get(v).add(u);
        }
        int[] countNodes = new int[n];
        CountNodes(gp, countNodes, 0, new boolean[n]);
        int[] distance = new int[n];
        distance[0] = rootDistance(gp, distance, 0, new boolean[n], countNodes);
        allVertexDist(gp, countNodes, distance, 0, new boolean[n]);
        return distance;
    }

    private void allVertexDist(List<List<Integer>> gp, int[] countNodes, int[] distance, int i, boolean[] bs) {

        bs[i] = true;
        for (int s : gp.get(i)) {
            if (!bs[s]) {
                distance[s] = distance[i] + gp.size() - 2 * countNodes[s];
                allVertexDist(gp, countNodes, distance, s, bs);
            }
        }
    }

    private int rootDistance(List<List<Integer>> gp, int[] distance, int src, boolean[] bs, int[] count) {
        bs[src] = true;
        int dist = 0;
        for (int i : gp.get(src)) {
            if (!bs[i]) {
                dist += rootDistance(gp, distance, i, bs, count) + count[i];
            }
        }
        return dist;
    }

    private int CountNodes(List<List<Integer>> gp, int[] countNodes, int src, boolean[] bs) {
        bs[src] = true;
        int cnt = 1;
        for (int i : gp.get(src)) {
            if (!bs[i]) {
                cnt += CountNodes(gp, countNodes, i, bs);
            }
        }
        countNodes[src] = cnt;
        return cnt;
    }
}