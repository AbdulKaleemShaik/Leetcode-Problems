class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                open++;
            else if (ch == ')') {
                if (open > close)
                    close++;
            }
        }
        open = close;
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (open > 0) {
                    sb.append(ch);
                    open--;
                }
            } else if (ch == ')') {
                if (open < close) {
                    sb.append(ch);
                    close--;
                }
            } else {
                sb.append(ch);
            }

        }
        return sb.toString();
    }
}