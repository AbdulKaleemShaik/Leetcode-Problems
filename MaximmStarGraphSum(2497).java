class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int sum = Integer.MIN_VALUE;
        if (edges.length == 0) {
            int summ = vals[0];
            for (int i = 0; i < vals.length; i++) {
                summ = Math.max(summ, vals[i]);
            }
            return summ;

        }
        int n = vals.length;
        List<List<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            gp.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            gp.get(edges[i][0]).add(vals[edges[i][1]]);
            gp.get(edges[i][1]).add(vals[edges[i][0]]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> curr = gp.get(i);
            curr.sort((a, b) -> b - a);
            int currSum = vals[i];
            for (int j = 0; j < k && j < curr.size() && curr.get(j)>0; j++) {
                currSum += curr.get(j);
            }
            sum = Math.max(sum, currSum);
        }
        return sum;
    }
}