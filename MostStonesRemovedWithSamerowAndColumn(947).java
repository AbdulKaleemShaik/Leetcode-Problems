class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public int removeStones(int[][] stones) {
        int ans = 0;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        for (int i = 0; i < maxCol + maxRow + 2; i++) {
            parent.add(i);
            size.add(1);
        }
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1] + maxRow + 1;
            unionBySize(row, col);
        }

        for (int i = 0; i < parent.size(); i++) {
            if (parent.get(i) == i && size.get(i) != 1) {
                ans++;
            }

        }
        return stones.length - ans;
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
}