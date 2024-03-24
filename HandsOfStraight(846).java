import java.util.PriorityQueue;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int ele : hand) {
            pq.add(ele);
        }
        while (!pq.isEmpty()) {
            int head = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(head + i))
                    return false;
            }
        }
        return true;
    }
}