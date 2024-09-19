import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> l1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> l2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : l1) {
                    for (int b : l2) {
                        if (ch == '+')
                            res.add(a + b);
                        else if (ch == '-')
                            res.add(a - b);
                        else
                            res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty())
            res.add(Integer.parseInt(expression));
        return res;
    }
}