import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    class pair {
        int quality;
        double ratio;

        pair(int quality, int wage) {
            this.quality = quality;
            this.ratio = wage / (double) quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<pair> li = new ArrayList<>();
        for (int i = 0; i < wage.length; i++) {
            li.add(new pair(quality[i], wage[i]));
        }
        double total = 0, ans = Integer.MAX_VALUE;
        Collections.sort(li, (a, b) -> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (pair p : li) {
            total += p.quality;
            pq.add((double) p.quality);
            if (pq.size() > k)
                total -= pq.remove();
            if (k == pq.size())
                ans = Math.min(ans, total * p.ratio);

        }
        return ans;

    }
}