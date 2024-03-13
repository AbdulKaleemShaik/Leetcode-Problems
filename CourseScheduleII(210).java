import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < pre.length; i++) {
            graph[pre[i][1]].add(pre[i][0]);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < pre.length; i++) {
            indegree[pre[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> li = new ArrayList<>();
        while (q.size() != 0) {
            int i = q.poll();
            li.add(i);
            for (int x : graph[i]) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }

        if (li.size() == numCourses) {
            int[] arr = new int[li.size()];
            for (int i = 0; i < indegree.length; i++) {
                arr[i] = li.get(i);
            }
            return arr;
        }
        return new int[] {};
    }
}