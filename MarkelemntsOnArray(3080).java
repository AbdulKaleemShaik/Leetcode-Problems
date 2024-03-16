import java.util.PriorityQueue;

class Solution {
    static class pair {
        int pos, val;

        pair(int p, int v) {
            this.pos = p;
            this.val = v;
        }
    }

    public static long[] unmarkedSumArray(int[] nums, int[][] queries) {
        long[] it = new long[queries.length];
        long sum = 0;
        boolean[] vis = new boolean[nums.length];
        PriorityQueue<pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.val - p2.val != 0) {
                return p1.val - p2.val;
            }
            return p1.pos - p2.pos;
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(new pair(i, nums[i]));
            sum += nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int j = queries[i][0];
            int k = queries[i][1];
            if (!vis[j]) {
                sum -= nums[j];
                vis[j] = true;
            }
            while (k > 0 && !pq.isEmpty()) {
                pair p = pq.remove();
                if (!vis[p.pos]) {
                    k--;
                    sum -= nums[p.pos];
                    vis[p.pos] = true;
                }
            }
            it[i] = sum;
        }
        return it;
    }
}