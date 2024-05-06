class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public int largestIsland(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        for (int i = 0; i < n * n; i++) {
            parent.add(i);
            size.add(1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int[] row = { 1, -1, 0, 0 };
                int[] col = { 0, 0, -1, 1 };
                for (int ind = 0; ind < 4; ind++) {
                    int newRow = i + row[ind];
                    int newCol = j + col[ind];
                    if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                        int nodeNo = i * n + j;
                        int adjNode = newRow * n + newCol;
                        unionBySize(nodeNo, adjNode);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                int[] row = { 1, -1, 0, 0 };
                int[] col = { 0, 0, -1, 1 };
                Set<Integer> set = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newRow = i + row[ind];
                    int newCol = j + col[ind];
                    if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                        set.add(findPar(newRow * n + newCol));
                    }

                }
                int total = 0;
                for (int k : set) {
                    total += size.get(k);
                }
                ans = Math.max(ans, total + 1);
            }
        }
        for (int i = 0; i < n * n; i++) {
            ans = Math.max(ans, size.get(findPar(i)));
        }

        return ans;
    }

    public int findPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));

        }
    }

    public boolean isValid(int i, int j, int m) {
        return i >= 0 && i < m && j >= 0 && j < m;
    }

}