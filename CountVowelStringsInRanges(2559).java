class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        List<Character> arr = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> set = new HashSet<>(arr);
        int[] prefixSum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            if (set.contains(curr.charAt(0)) && set.contains(curr.charAt(curr.length() - 1))) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];

            }
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }
        return ans;
    }
}