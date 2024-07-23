class Solution {
    public int[] frequencySort(int[] nums) {
          Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                int ele = map.get(a) - map.get(b);
                if (ele != 0) {
                    return ele;
                } else {
                    return b - a;
                }
            });
            for (int x : map.keySet()) {
                pq.add(x);
            }
            int[] ans = new int[nums.length];
            int i = 0;
            while (!pq.isEmpty()) {
                int x = pq.poll();
                for (int j = 0; j < map.get(x); j++) {
                    ans[i++] = x;
                }
            }
            return ans;
    }
}