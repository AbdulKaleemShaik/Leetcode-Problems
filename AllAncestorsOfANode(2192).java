import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            gp.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(gp, ans, i, i, new boolean[n]);
        }
        for (int i = 0; i < n; i++) {
            ans.get(i).sort(Integer::compareTo);
        }
        return ans;
    }

    public void dfs(List<List<Integer>> gp, List<List<Integer>> res, int curr, int parent, boolean[] vis) {
        vis[curr] = true;
        for (int i : gp.get(curr)) {
            if (!vis[i]) {
                res.get(i).add(parent);
                dfs(gp, res, i, parent, vis);
            }
        }

    }
}