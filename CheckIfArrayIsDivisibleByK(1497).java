class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] visited = new int[k];
        for (int i : arr) {
            visited[((i % k) + k) % k]++;
        }
        if (visited[0] % 2 != 0)
            return false;
        for (int i = 1; i < k; i++) {
            if (visited[i] != visited[k - i])
                return false;
        }
        return true;
    }
}