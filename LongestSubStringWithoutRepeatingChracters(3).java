import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        Set<Character> st = new HashSet<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (!st.contains(s.charAt(r))) {
                st.add(s.charAt(r));
                maxlen = Math.max(maxlen, r - l + 1);
                r++;
            } else {
                st.remove(s.charAt(l));
                l++;
            }
        }
        return maxlen;
    }
}