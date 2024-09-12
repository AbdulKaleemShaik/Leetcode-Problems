import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Character> set = new HashSet<>();

    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        for (String s : words) {
            ans += isValid(s);
        }
        return ans;
    }

    public int isValid(String s) {
        for (char ch : s.toCharArray()) {
            if (!set.contains(ch))
                return 0;
        }
        return 1;
    }
}