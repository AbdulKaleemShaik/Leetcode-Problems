import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(')
                continue;
            if (ch == '!' || ch == '&' || ch == '|' || ch == 't' || ch == 'f') {
                st.push(ch);
            } else if (ch == ')') {
                boolean hasTrue = false, hasFalse = false;
                while (st.peek() != '!' && st.peek() != '&' && st.peek() != '|') {
                    char c = st.pop();
                    if (c == 't') {
                        hasTrue = true;
                    } else {
                        hasFalse = true;
                    }
                }
                char op = st.pop();
                if (op == '!') {
                    st.push(hasTrue ? 'f' : 't');
                } else if (op == '&') {
                    st.push(hasFalse ? 'f' : 't');
                } else {
                    st.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return st.peek() == 't';
    }
}