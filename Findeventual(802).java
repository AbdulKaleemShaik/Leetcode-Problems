import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] gp) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer>[] ed = new ArrayList[gp.length];

        for (int i = 0; i < ed.length; i++) {
            ed[i] = new ArrayList<>();
        }
        for (int i = 0; i < gp.length; i++) {
            for (int j = 0; j < gp[i].length; j++) {
                ed[gp[i][j]].add(i);
            }
        }
        int[] indegree = new int[gp.length];
        for (int i = 0; i < gp.length; i++) {
            indegree[i] = gp[i].length;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.size() != 0) {
            int i = q.poll();
            ans.add(i);
            for (var x : ed[i]) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        Collections.sort(ans);
        return ans;
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[gp.length];
        for (int i = 0; i < gp.length; i++) {
            if (vis[i] == 0) {
                dfs(gp, vis, i);
            }
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 2) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean dfs(int[][] gp, int[] vis, int curr) {
        vis[curr] = 1;
        for (int i : gp[curr]) {
            if (vis[i] == 0) {
                if (dfs(gp, vis, i)) {
                    return true;
                }
            }
            if (vis[i] == 1) {
                return true;
            }
        }
        vis[curr] = 2;
        return false;

    }
}