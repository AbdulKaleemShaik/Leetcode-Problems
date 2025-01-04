import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        Set<Character> left = new HashSet<>();
        int[] right = new int[26];
        for (char i : s.toCharArray()) {
            right[i - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char mid = s.charAt(i);
            right[mid - 'a']--;
            if (right[mid - 'a'] == 0)
                right[mid - 'a'] = 0;
            for (int j = 0; j < 26; j++) {
                char outer = (char) ('a' + j);
                if (left.contains(outer) && right[j] > 0) {
                    set.add("" + outer + mid + outer);
                }
            }
            left.add(mid);
        }
        return set.size();
    }
}