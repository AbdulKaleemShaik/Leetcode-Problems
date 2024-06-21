class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0)
                ans += customers[i];
        }
        int score = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                score = Math.max(score, find(grumpy, customers, i, i + minutes, minutes));
            }
        }

        return ans + score;

    }

    public int find(int[] arr, int[] grumpy, int i, int j, int minutes) {
        int cost = 0;
        while (i < j && i < arr.length) {
            if (arr[i] == 1)
                cost += grumpy[i];
            i++;
        }
        return cost;
    }

}