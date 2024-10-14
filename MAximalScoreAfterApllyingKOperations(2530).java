import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : nums) {
            pq.add(i);
        }
        while (k-- != 0) {
            int i = pq.poll();
            ans += i;
            if (i % 3 != 0) {
                i = i / 3 + 1;
            } else {
                i = i / 3;
            }
            pq.add((int) Math.ceil(i / 3.0));
            pq.add(i);
        }
        return ans;
    }
}