import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : restricted) {
            set.add(integer);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int count = 1;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : graph.get(curr)) {
                if (!(set.contains(i)) && !vis[i]) {
                    q.add(i);
                    vis[i] = true;
                    count++;
                }

            }
        }
        return count;

    }
}