class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>(dict);
        StringBuilder ans = new StringBuilder();
        List<String> li = new ArrayList<>(
                Arrays.asList(sentence.split(" ")));

        for (String t : li) {
            int i = 0;
            while (i <= t.length()) {
                String curr = t.substring(0, i++);
                if (set.contains(curr)) {
                    ans.append(curr).append(" ");
                    break;
                }

                if (i == t.length() + 1)
                    ans.append(t).append(" ");
            }
        }

        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();

    }

}