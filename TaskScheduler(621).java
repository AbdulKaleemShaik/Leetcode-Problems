import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());
        Queue<pair> q = new LinkedList<>();
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int p = pq.poll();
                p = p + 1;

                if (p != 0) {
                    q.add(new pair(time + n, p));
                }
            }
            if (!q.isEmpty()) {
                if (time == q.peek().time) {
                    pq.add(q.poll().process);
                }
            }
        }

        return time;
    }
}

class pair {
    int time;
    int process;

    pair(int i, int j) {
        this.process = j;
        this.time = i;
    }
}