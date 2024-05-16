class Solution {
    int t = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.size(); i++) {
            gp.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            gp.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        dfs(gp, new int[n], new int[n], new int[n], 0, -1, ans);
        return ans;
    }

    public void dfs(List<List<Integer>> gp, int[] vis, int[] time, int[] low, int node, int parent,
            List<List<Integer>> ans) {
        vis[node] = 1;
        time[node] = low[node] = t++;
        for (int i : gp.get(node)) {
            if (i == parent)
                continue;
            if (vis[i] == 0) {
                dfs(gp, vis, time, low, i, node, ans);
                low[node] = Math.min(low[i], low[node]);
                if (low[i] > time[node]) {
                    ans.add(Arrays.asList(node, i));
                }
            } else {
                low[node] = Math.min(low[node], low[i]);
            }
        }

    }
}