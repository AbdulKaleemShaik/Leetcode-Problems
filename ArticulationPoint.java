import java.util.ArrayList;

 
 class Articulationpoint {
    int t = 1;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] vis = new int[V];
        int[] time = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(adj, vis, time, low, mark, 0, -1);
            }
        }
        for (int i = 0; i < V; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> gp, int[] vis, int[] time, int[] low, int[] mark, int node,
            int parent) {
        vis[node] = 1;
        time[node] = low[node] = t++;
        int child = 0;
        for (int i : gp.get(node)) {
            if (i == parent)
                continue;
            if (vis[i] == 0) {
                dfs(gp, vis, time, low, mark, i, node);
                low[node] = Math.min(low[i], low[node]);
                if (low[i] > time[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], time[i]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }

    }
}