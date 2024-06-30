public class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUF = new UnionFind(n);
        UnionFind bobUF = new UnionFind(n);
        int totalEdges = 0;
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;

            if (type == 3) {
                boolean aliceConnected = aliceUF.union(u, v);
                boolean bobConnected = bobUF.union(u, v);
                if (aliceConnected || bobConnected) {
                    totalEdges++;
                }
            } else if (type == 1) {
                if (aliceUF.union(u, v)) {
                    totalEdges++;
                }
            } else if (type == 2) {
                if (bobUF.union(u, v)) {
                    totalEdges++;
                }
            }
        }
        if (aliceUF.getComponents() > 1 || bobUF.getComponents() > 1) {
            return -1;
        }
        return edges.length - totalEdges;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int upx = find(x);
        int upy = find(y);

        if (upx != upy) {
            if (rank[upx] > rank[upy]) {
                parent[upy] = upx;
            } else if (rank[upx] < rank[upy]) {
                parent[upx] = upy;
            } else {
                parent[upy] = upx;
                rank[upx]++;
            }
            count--;
            return true;
        }
        return false;
    }

    public int getComponents() {
        return count;
    }
} RemoveMaximumNoOfNodes(1579) {
    
}
