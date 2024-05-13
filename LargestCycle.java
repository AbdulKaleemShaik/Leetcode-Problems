
import java.util.ArrayList;

class LargestCycle {
    static ArrayList<Integer> vis;
    static ArrayList<Integer> pos;
    static int res = 0;
    static int currlength = 0;

    static void dfs(int arr[], int node) {
        if (vis.get(node) == 1) {
            return;
        }
        if (arr[node] == -1) {
            vis.set(node, 1);
            return;
        }

        if (pos.get(node) != -1) {
            res = Math.max(res, currlength - pos.get(node));
            vis.set(node, 1);
            return;
        }

        pos.set(node, currlength);
        currlength++;
        dfs(arr, arr[node]);
        vis.set(node, 1);
        pos.set(node, -1);

    }

    public static int findLongestCycle(int[] arr) {
        int n = arr.length;

        vis = new ArrayList<Integer>(n);
        pos = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            vis.add(0);
            pos.add(-1);
        }

        res = 0;

        for (int i = 0; i < n; i++) {
            if (vis.get(i) == 0) {
                currlength = 0;
                dfs(arr, i);
            }
        }

        if (res == 0) {
            return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        findLongestCycle(new int[] { 1, 2, 3, 4, 5, 0 });
    }
}