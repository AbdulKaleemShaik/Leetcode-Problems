class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int ans = 0;
        int maxDiffculty = Arrays.stream(difficulty).max().getAsInt();
        int[] maxProfitArray = new int[maxDiffculty + 1];
        for (int i = 0; i < difficulty.length; i++)
            maxProfitArray[difficulty[i]] = Math.max(maxProfitArray[difficulty[i]],profit[i]);
        for (int i = 1; i < maxDiffculty + 1; i++)
            maxProfitArray[i] = Math.max(maxProfitArray[i], maxProfitArray[i - 1]);
        for (int i : worker) {
            if (i > maxDiffculty)
                ans += maxProfitArray[maxDiffculty];
            else
                ans += maxProfitArray[i];
        }
        return ans;
    }
}