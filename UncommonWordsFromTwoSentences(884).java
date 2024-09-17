import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // String curr=s1+" "+s2;
        // String[] arr=curr.split(" ");
        Map<String, Integer> map = new HashMap<>();
        // int size=0;
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1)
                ans.add(word);
        }
        return ans.toArray(new String[ans.size()]);
    }
}