public import java.util.*;

public class BridgeAndTorchProblem {

    public static void main(String[] args) {
        int[] times = { 1, 2, 7, 10 };
        int leastTime = findLeastTime(times);
        System.out.println("Least time taken: " + leastTime + " minutes");
    }

    public static int findLeastTime(int[] times) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int time : times) {
            pq.offer(time);
        }
        int totalTime = 0;
        while (pq.size() > 0) {
            if (pq.size() == 1) {
                totalTime += pq.poll();
            } else if (pq.size() == 2) {
                pq.poll();
                totalTime += pq.poll();
            } else {
                int first = pq.poll();
                int second = pq.poll();
                totalTime += second;
                totalTime += first;
                pq.offer(first);
            }
        }

        return totalTime;
    }
}
 {
    
}
