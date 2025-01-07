import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i] == words[j])
                    continue;
                if (words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}