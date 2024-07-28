import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
         List<Integer>[] gp = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++)
            gp[i] = new ArrayList<>();
        for (int[] edge : edges) {
            gp[edge[0]].add(edge[1]);
            gp[edge[1]].add(edge[0]);
        }

        Queue<int[]> deque = new LinkedList<>();
        int[] visitedNum = new int[n + 1];
        int[] timeArr = new int[n + 1];
        Arrays.fill(timeArr, -1);
        deque.offer(new int[] { 1, 0 });
        timeArr[0] = 0;

        while (!deque.isEmpty()) {
            int curSize = deque.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = deque.poll();
                int curNode = cur[0], curTime = cur[1];

                int availableTime = 0;
                int curLight = curTime / change;
                if (curLight % 2 == 0) {
                    availableTime = curTime + time;
                } else {
                    availableTime = (curLight + 1) * change + time;
                }

                for (int next : gp[curNode]) {
                    if (visitedNum[next] < 2 && timeArr[next] < availableTime) {
                        deque.offer(new int[] { next, availableTime });
                        visitedNum[next]++;
                        timeArr[next] = availableTime;
                        if (next == n && visitedNum[next] == 2)
                            return availableTime;
                    }
                }
            }
        }
        return -1;
    }
}