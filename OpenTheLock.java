import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> st = new HashSet<>();

        for (String s : deadends) {
            if (s.equals("0000")) {
                return -1;
            }
            st.add(s);
        }
        Queue<pair> q = new LinkedList<>();
        q.add(new pair("0000", 0));
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        while (!q.isEmpty()) {
            String s = q.peek().currr;
            int t = q.peek().time;
            q.poll();
            if (s.equals(target)) {
                return t;
            }
            for (int i = 0; i < 4; i++) {
                char[] ch = s.toCharArray();
                ch[i] = findleft((s.charAt(i)));
                if (!st.contains(new String(ch)) && !vis.contains(new String(ch))) {
                    q.add(new pair(new String(ch), t + 1));
                    vis.add(new String(ch));
                }
                ch[i] = fingRight((s.charAt(i)));
                if (!st.contains(new String(ch)) && !vis.contains(new String(ch))) {
                    q.add(new pair(new String(ch), t + 1));
                    vis.add(new String(ch));

                }
            }
        }
        return -1;
    }

    public char findleft(char i) {
        if (i == '0') {
            return '9';
        }
        return (char) (i - 1);
    }

    public char fingRight(char i) {
        if (i == '9') {
            return '0';
        }
        return (char) (i + 1);
    }

}

class pair {
    String currr;
    int time;

    pair(String currr, int i) {
        this.currr = currr;
        this.time = i;
    }
}