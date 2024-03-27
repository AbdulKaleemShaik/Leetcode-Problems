class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
         Set<String> st = new HashSet<>();
        for (String string : wordList) {
            st.add(string);
        }
        int level = 0;
        st.remove(beginWord);
        List<List<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> li = new ArrayList<String>();
        ArrayList<String> usedonLevel = new ArrayList<>();
        usedonLevel.add(beginWord);
        li.add(beginWord);
        q.add(li);
        while (!q.isEmpty()) {
            ArrayList<String> curr = q.peek();
            q.poll();
            if (curr.size() > level) {
                level++;
                for (String it : usedonLevel) {
                    st.remove(it);
                }
            }
            if (curr.get(curr.size() - 1).equals(endWord)) {
                if (ans.size() == 0)
                    ans.add(curr);
                else if (ans.get(0).size() == curr.size()) {
                    ans.add(curr);
                }

            }
            String s1 = curr.get(curr.size() - 1);
            for (int i = 0; i < s1.length(); i++) {
                char[] ch = s1.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;
                    String s2 = new String(ch);
                    if (st.contains(s2)) {
                        curr.add(s2);
                        ArrayList<String> a = new ArrayList<>(curr);
                        q.add(a);
                        usedonLevel.add(s2);
                        curr.remove(curr.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
}