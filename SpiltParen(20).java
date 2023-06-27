import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (char a : s.toCharArray()) {
            if (a == '(' || a == '{' || a == '[') {
                st.push(a);
            }
        
            else if (a == ')' && !st.empty() && st.peek() == '(')
                st.pop();
            else if (a == '}' && !st.empty() && st.peek() == '{')
                st.pop();
            else if (a == ']' && !st.empty() && st.peek() == '[')
                st.pop();
            else
                return false;
        }
        return st.empty();
    }
}
