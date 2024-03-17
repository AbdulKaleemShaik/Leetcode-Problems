class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        long[] arr = new long[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[i] = count;
            if (ch == c) {
                count++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count += arr[i];
            }
        }
        return count;
    }
}