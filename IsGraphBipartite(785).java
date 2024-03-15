import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            ed.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                ed.get(i).add(graph[i][j]);
            }
        }
        int[] vis = new int[graph.length];
        Arrays.fill(vis, -1);
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == -1) {
                vis[i] = 0;
                if (!bipartite(ed, vis, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bipartite(ArrayList<ArrayList<Integer>> ed, int[] vis, int node) {
        for (int i = 0; i < ed.get(node).size(); i++) {
            int ele = ed.get(node).get(i);
            if (vis[ele] == -1) {
                vis[ele] = 1 - vis[node];
                if (!bipartite(ed, vis, ele)) {
                    return false;
                }
            } else if (vis[node] == vis[ele]) {
                return false;
            }
        }
        return true;
    }
}