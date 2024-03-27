class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for (String s : wordList) {
            st.add(s);
        }
        st.remove(beginWord);
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(beginWord, 1));
        while (!q.isEmpty()) {
            String curr = q.peek().word;
            int steps = q.peek().steps;
            q.poll();
            if (curr.equals(endWord)) {
                return steps;
            }
            for (int i = 0; i < curr.length(); i++) {
                char[] ch = curr.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    ch[i] = j;
                    String s = new String(ch);
                    if (st.contains(s)) {
                        q.add(new pair(s, steps + 1));
                        st.remove(s);
                    }
                }
            }
            st.remove(curr);
        }
        return 0;
    }
}
class pair {
    String word;
    int steps;

    pair(String i, int j) {
        this.word = i;
        this.steps = j;
    }
}