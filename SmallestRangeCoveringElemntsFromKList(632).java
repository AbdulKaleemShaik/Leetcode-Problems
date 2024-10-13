import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
       int size = nums.size();
       int left = nums.get(0).get(0);
       int right = nums.get(0).get(0);
       PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.i - b.i);

       for (int i = 0; i < size; i++) {
           List<Integer> curr = nums.get(i);
           left = Math.min(left, curr.get(0));
           right = Math.max(right, curr.get(0));
           pq.add(new pair(curr.get(0), i, 0));
       }
       int[] res = new int[2];
       res[0] = left;
       res[1] = right;
       while (true) {
           pair p = pq.poll();
           int i = p.i, j = p.j, k = p.k;
           k = k + 1;
           if (k == nums.get(j).size())
               break;
           pq.add(new pair(nums.get(j).get(k), j, k));
           right = Math.max(right, nums.get(j).get(k));
           left = pq.peek().i;

           if (right - left < res[1] - res[0]) {
               res[0] = left;
               res[1] = right;
           }

       }
       return res;

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
