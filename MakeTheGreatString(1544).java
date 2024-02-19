import java.util.Stack;

class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (!st.isEmpty() && (ch == st.peek() - 32 || ch == st.peek() + 32)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        String s1 = "";
        while (!st.isEmpty()) {
            s1 = st.pop() + s1;
        }
        return s1;
    }
}