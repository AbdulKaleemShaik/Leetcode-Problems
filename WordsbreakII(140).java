class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String i : wordDict) {
            set.add(i);
        }
        addAll(s, set, ans, temp, 0, "");
        return ans;
    }

    public void addAll(String s, Set<String> set, List<String> ans, List<String> temp, int i, String path) {
        if (i >= s.length()) {
            String listString = new String();
            for (int j = 0; j < temp.size(); j++) {
                listString = listString + " " + temp.get(j);
            }
            ans.add(listString.trim().toString());
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String curr = s.substring(i, j + 1);
            if (set.contains(curr)) {
                temp.add(curr);
                addAll(s, set, ans, temp, j + 1, path);
                temp.remove(temp.size() - 1);

            }
        }
    }
}