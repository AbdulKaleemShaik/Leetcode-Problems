import java.util.Stack;

class Solution {
    public int minLength(String s) {

        Stack<Character> st = new Stack<>();
        if (s.length() == 1) {
            st.push(s.charAt(0));
            return st.size();
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B' || s.charAt(i) == 'D') {
                int j = s.charAt(i);
                if (!st.isEmpty() && (j - 1) == st.peek()) {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        return st.size();
    }
}
