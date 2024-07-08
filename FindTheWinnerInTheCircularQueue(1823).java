class Solution {
    public int findTheWinner(int n, int k) {
        return find(n, k) + 1;
    }

    public int find(int n, int k) {
        if (n == 1)
            return 0;
        int j = ((find(n - 1, k) + k) % n);
        return j;
    }

}