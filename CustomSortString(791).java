import java.util.HashMap;

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j2 = 0; j2 < s.length(); j2++) {
            map.put(s.charAt(j2), map.getOrDefault(s.charAt(j2), 0) + 1);
        }
        while (i < order.length()) {
            if (map.containsKey(order.charAt(i))) {

                if (map.get(order.charAt(i)) > 1) {
                    int k = map.get(order.charAt(i));
                    while (k != 0) {
                        sb.append(order.charAt(i));
                        k--;
                    }
                    map.remove(order.charAt(i));
                } else {
                    sb.append(order.charAt(i));
                    map.remove(order.charAt(i));
                }
            }
            i++;
        }

        for (HashMap.Entry<Character, Integer> m : map.entrySet()) {
            int ch = m.getValue();
            for (int j = 0; j < ch; j++) {
                sb.append(m.getKey());
            }

        }

        return sb.toString();
        // StringBuilder sb = new StringBuilder();
        // int[] map = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        // map[s.charAt(i) - 'a']++;
        // }
        // for (int i = 0; i < order.length(); i++) {
        // for (int j = 0; j < map[order.charAt(i) - 'a']; j++) {
        // sb.append(order.charAt(i));
        // }
        // map[order.charAt(i) - 'a'] = 0;
        // }
        // for (int i = 0; i < map.length; i++) {
        // for (int j = 0; j < map[i]; j++) {
        // sb.append((char)( 'a' + i));
        // }
        // }
        // return sb.toString();
    }
}