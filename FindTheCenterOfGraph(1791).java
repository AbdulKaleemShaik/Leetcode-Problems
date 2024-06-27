class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 2;
        int[] dis = new int[n];
        for (int i = 0; i < edges.length; i++) {
            dis[edges[i][0]]++;
            dis[edges[i][1]]++;
        }
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == edges.length)
                return i;
        }

        // e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];

        return 0;
    }
}