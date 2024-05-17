
import java.util.*;
import java.util.ArrayList;

public class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int Vertices = sc.nextInt();
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < Vertices; i++) {
            gp.add(new ArrayList<>());
        }
        int Edges = sc.nextInt();
        for (int i = 0; i < Edges; i++) {
            int node = sc.nextInt();
            int adj = sc.nextInt();
            gp.get(node).add(adj);
        }
        Stack<Integer> Order = new Stack<>();
        boolean[] vis = new boolean[Vertices];
        for (int i = 0; i < Vertices; i++) {
            if (!vis[i]) {
                dfs(gp, vis, i, Order);
            }
        }
        List<List<Integer>> gpRev = new ArrayList<>();
        for (int i = 0; i < Vertices; i++) {
            gpRev.add(new ArrayList<>());
        }
        for (int i = 0; i < gp.size(); i++) {
            vis[i] = false;
            for (int j = 0; j < gp.get(i).size(); j++) {
                gpRev.get(gp.get(i).get(j)).add(i);
            }
        }

        int ans = 0;
        for (int i = 0; i < Vertices; i++) {
            if (!vis[i]) {
                dfs2(gpRev, vis, i);
                ans++;
            }
        }
        System.out.println(ans);

    }

    public static void dfs(List<List<Integer>> gp, boolean[] vis, int node, Stack<Integer> Order) {
        vis[node] = true;
        for (int i : gp.get(node)) {
            if (!vis[i]) {
                dfs(gp, vis, i, Order);
            }
        }
        Order.push(node);
    }

    public static void dfs2(List<List<Integer>> gp, boolean[] vis, int node) {
        vis[node] = true;
        for (int i : gp.get(node)) {
            if (!vis[i]) {
                dfs2(gp, vis, i);
            }
        }

    }

}
