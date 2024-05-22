import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        find(s, 0, currPath, ans);
        return ans;
    }

    private void find(String s, int i, List<String> currPath, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(currPath));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                currPath.add(s.substring(i, j + 1));
                find(s, j + 1, currPath, ans);
                currPath.remove(currPath.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}