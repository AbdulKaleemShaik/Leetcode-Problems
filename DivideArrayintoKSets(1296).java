import java.util.PriorityQueue;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : nums) {
            pq.add(ele);
        }
        while (!pq.isEmpty()) {
            int head = pq.poll();
            for (int i = 1; i < k; i++) {
                if (!pq.remove(head + i))
                    return false;
            }
        }
        return true;
    }
}
