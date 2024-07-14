import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> st = new Stack<>();
        st.push(new HashMap<>());
        int len = formula.length();

        for (int i = 0; i < len;) {
            if (formula.charAt(i) == '(') {
                st.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = st.pop();
                i++;
                int j = i;
                while (i < len && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplier = j < i ? Integer.parseInt(formula.substring(j, i)) : 1;
                for (String key : top.keySet()) {
                    st.peek().put(key, st.peek().getOrDefault(key, 0) + top.get(key) * multiplier);
                }
            } else {
                int j = i;
                i++;
                while (i < len && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String element = formula.substring(j, i);
                j = i;
                while (i < len && Character.isDigit(formula.charAt(i)))
                    i++;
                int count = j < i ? Integer.parseInt(formula.substring(j, i)) : 1;
                st.peek().put(element, st.peek().getOrDefault(element, 0) + count);
            }
        }

        Map<String, Integer> ans = st.pop();
        List<String> elements = new ArrayList<>(ans.keySet());
        Collections.sort(elements);
        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            sb.append(element);
            int count = ans.get(element);
            if (count > 1)
                sb.append(count);
        }
        return sb.toString();
    }
}