class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] vis = new Boolean[s.length()];
        return isValid(0, s, set, vis);
    }

    private boolean isValid(int i, String s, Set<String> set, Boolean[] vis) {
        if (i == s.length()) {
            return true;
        }
        if (vis[i] != null) {
            return vis[i];
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j)) && isValid(j, s, set, vis)) {
                return vis[i] = true;
            }
        }
        return vis[i] = false;
    }
}