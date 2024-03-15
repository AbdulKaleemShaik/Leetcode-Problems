class Solution {
    public static int findCircleNum(int[][] mat) {
        int cnt = 0, n = mat.length;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, vis, mat);
            }
        }
        return cnt;
    }

    public static void dfs(int n, boolean[] visit, int[][] mat) {
        visit[n] = true;
        for (int i = 0; i < mat.length; i++) {
            if (!visit[i] && mat[n][i] == 1)
                dfs(i, visit, mat);
        }
    }
}