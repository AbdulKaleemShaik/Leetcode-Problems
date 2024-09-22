import java.util.PriorityQueue;

public class JobSequencing {
    public static int[] jobScheduling(int[][] jobs) {
        int[] ans = new int[2];
        int time = Integer.MIN_VALUE;
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> b.k - a.k);
        for (int i = 0; i < jobs.length; i++) {
            time = Math.max(time, jobs[i][1]);
            pq.add(new pair(jobs[i][0], jobs[i][1], jobs[i][2]));
        }
        int count = 0, sum = 0;
        boolean[] vis = new boolean[time];
        while (!pq.isEmpty()) {
            int t = pq.peek().j;
            int profit = pq.peek().k;
            pq.poll();
            if (find(t - 1, vis)) {
                count++;
                sum += profit;
            }
        }

        ans[0] = count;
        ans[1] = sum;
        return ans;
    }

    public static boolean find(int i, boolean[] vis) {
        for (int j = i; j >= 0; j--) {
            if (!vis[j]) {
                vis[j] = true;
                return true;
            }
        }
        return false;
    }
}

class pair {
    int i, j, k;

    pair(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
