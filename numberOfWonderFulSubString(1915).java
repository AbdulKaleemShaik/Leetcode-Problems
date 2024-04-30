import java.util.HashMap;
import java.util.Map;

class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        long ans = 0;
        int mask = 0;

        for (char ch : word.toCharArray()) {
            int charIndex = ch - 'a';
            mask ^= 1 << charIndex;
            ans += map.getOrDefault(mask, 0);
            for (int i = 0; i < 10; i++) {
                ans += map.getOrDefault(mask ^ (1 << i), 0);
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }

        return ans;
    }
}