class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        find(1, n, k, new ArrayList<>(), ans);
        return ans;
    }

    public void find(int i, int n, int k, List<Integer> curr, List<List<Integer>> ans) {
        if (curr.size() == k && n == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j <= 9; j++) {
            if (!curr.contains(j) && j <= n) {
                curr.add(j);
                find(j + 1, n - j, k, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
}