class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);
        }
        String[] s1 = new String[pq.peek() + 1];
        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                s1[pq.poll()] = "Gold Medal";
            } else if (i == 1) {
                s1[pq.poll()] = "Silver Medal";
            } else if (i == 2) {
                s1[pq.poll()] = "Bronze Medal";
            } else {
                s1[pq.poll()] = "" + (i + 1);
            }
        }
        for (int i = 0; i < score.length; i++) {
            ans[i] = s1[score[i]];
        }
        return ans;
    }
}