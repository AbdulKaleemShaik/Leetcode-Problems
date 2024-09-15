import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int findTheLongestSubstring(String s) {
        int bitwise = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                bitwise ^= ch ;
            }
            if (map.containsKey(bitwise)) {
                ans = Math.max(ans, i - map.get(bitwise));
            } else {
                map.put(bitwise, i);
            }
            i++;
           // System.out.println(map);
        }
        return ans;
    }
}