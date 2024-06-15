import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int j = 0;
        int n = profits.length;
        List<Pair> pairs = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; ++i) {
            pairs.add(new Pair(capital[i], profits[i]));
        }

        Collections.sort(pairs, (a, b) -> a.capital - b.capital);
        while (k-- > 0) {
            while (j < n && w >= pairs.get(j).capital) {
                maxHeap.offer(pairs.get(j++).profit);
            }

            if (maxHeap.isEmpty())
                break;
            w += maxHeap.poll();
        }
        return w;
    }
}

class Pair {
    int capital;
    int profit;

    Pair(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}