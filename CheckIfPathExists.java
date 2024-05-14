import java.util.ArrayList;
import java.util.List;

 class Solution {
	public static boolean checkPathExists(int v, int e, int source, int destination, int[][] edges) {
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            gp.get(edges[i][0]).add(edges[i][1]);
        }

        return find(gp, source, destination, new boolean[v]);
    }

    public static boolean find(List<List<Integer>> gp, int src, int dest, boolean[] vis) {
        if (src == dest)
            return true;
        vis[src] = true;
        for (int i : gp.get(src)) {
            if (!vis[i]) {
                if (find(gp, i, dest, vis)) {
                    return true;
                }
                ;
            }

        }
        return false;
    }

}
