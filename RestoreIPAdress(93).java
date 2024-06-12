import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        findAll(ans, "", 0, 0, s);
        return ans;
    }

    public void findAll(List<String> ans, String curr, int i, int dots, String s) {

        if (dots == 4 && i == s.length()) {
            String s1 = curr.substring(0, curr.length() - 1);
            ans.add(s1);
            return;
        }
        if (dots > 4)
            return;

        for (int j = i; j < Math.min(s.length(), i + 3); j++) {
            String sub = s.substring(i, j + 1);

            int val = Integer.parseInt(sub);
            if (val < 256 && (i == j || sub.charAt(0) != '0'))
                findAll(ans, curr + sub + ".", j + 1, dots + 1, s);

        }

    }
}