import java.util.ArrayList;
import java.util.List;

 class Solution {
     public static int[] numberOfIslandII(int n, int m, int[][] queries, int q) {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        for (int i = 0; i < m * n; i++) {
            parent.add(i);
            size.add(1);
        }
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            int[] rows = { 1, -1, 0, 0 };
            int[] cols = { 0, 0, 1, -1 };
            for (int j = 0; j < 4; j++) {
                int newRow = row + rows[j];
                int newCol = col + cols[j];
                if (isValid(newRow, newCol, n, m) && vis[newRow][newCol] == 1) {
                    int nodeNo = row * m + col;
                    int adjNo = newRow * m + newCol;
                    if (findPar(nodeNo, parent) != findPar(adjNo, parent)) {
                        cnt--;
                        unionBySize(nodeNo, adjNo, size, parent);
                    }

                }
            }
            ans.add(cnt);
        }
        int[] arr = ans.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    public static int findPar(int node, List<Integer> parent) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findPar(parent.get(node), parent);
        parent.set(node, ulp);
        return parent.get(node);
    }

    public static void unionBySize(int u, int v, List<Integer> size, List<Integer> parent) {
        int ulp_u = findPar(u, parent);
        int ulp_v = findPar(v, parent);
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

   public static boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
   }
}