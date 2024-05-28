class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxlen = 0;
        int currSum = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            currSum += Math.abs(s.charAt(i) - t.charAt(i));
            while (currSum > maxCost) {
                currSum -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxlen = Math.max(maxlen, i - start + 1);
        }
        return maxlen;
    }
}