class Solution {
    // public String reverseParentheses(String s) {
    // Stack<Character> st = new Stack<>();
    // List<Character> li = new ArrayList<>();
    // for (int i = 0; i < s.length(); i++) {
    // if (s.charAt(i) == ')') {
    // li = new ArrayList<>();
    // while (!st.isEmpty() && st.peek() != '(') {
    // li.add(st.pop());
    // }
    // st.pop();
    // for (int k = 0; k < li.size(); k++) {
    // st.add(li.get(k));
    // }
    // } else {
    // st.add(s.charAt(i));
    // }
    // }
    // // System.out.println(st);
    // StringBuilder sb = new StringBuilder();
    // while (!st.isEmpty()) {
    // sb.append(st.pop());

    // }
    // // System.out.println(sb);
    // return sb.reverse().toString();
    // }
    int i = 0;

    public String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s) {
        StringBuilder sb = new StringBuilder();

        while (i < s.length) {
            if (s[i] == ')') {
                i++;
                return sb.reverse().toString();
            } else if (s[i] == '(') {
                i++;
                String st = helper(s);
                sb.append(st);
            } else {
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}