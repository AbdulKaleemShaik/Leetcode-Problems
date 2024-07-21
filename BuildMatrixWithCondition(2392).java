import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(rowConditions, k);
        List<Integer> colOrder = topologicalSort(colConditions, k);
        // System.out.println(rowOrder);
        // System.out.println(colOrder);
        if (rowOrder.size() != k || colOrder.size() != k)
            return new int[][] {};
        HashMap<Integer, Integer> rowhash = new HashMap<>();
        HashMap<Integer, Integer> colhash = new HashMap<>();
        for (int i = 0; i < k; i++) {
            rowhash.put(rowOrder.get(i), i);
            colhash.put(colOrder.get(i), i);
        }
        // System.out.println(rowhash);
        // System.out.println(colhash);
        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; i++) {
            int rowNumber = rowhash.get(i);
            int colNumber = colhash.get(i);
            ans[rowNumber][colNumber] = i;
        }
        for (int[] is : ans) {
            System.out.println(Arrays.toString(is));
        }
        return ans;
    }

    public List<Integer> topologicalSort(int[][] arr, int k) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            gp.get(arr[i][0]).add(arr[i][1]);
        }
        int[] indegree = new int[k + 1];
        for (int i = 0; i < arr.length; i++) {
            indegree[arr[i][1]]++;
        }
        // System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        // System.out.println(q);
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int i : gp.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0)
                    q.add(i);
            }

        }
        // System.out.println(ans);
        return ans;
    }
}