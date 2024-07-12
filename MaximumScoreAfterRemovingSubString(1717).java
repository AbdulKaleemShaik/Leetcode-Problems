import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        char bigger = x > y ? 'a' : 'b';
        char smaller = bigger == 'a' ? 'b' : 'a';
        int highestScore = x > y ? x : y;
        int lowestScore = highestScore == x ? y : x;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == bigger && s.charAt(i) == smaller) {
                st.pop();
                ans += highestScore;
            } else {
                st.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb = sb.reverse();
        st = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (!st.isEmpty() && st.peek() == smaller && sb.charAt(i) == bigger) {
                st.pop();
                ans += lowestScore;
            } else {
                st.add(sb.charAt(i));
            }
        }
        return ans;
    }

    // int aCount = 0;
    // int bCount = 0;
    // int lesser = Math.min(x, y);
    // int result = 0;

    // for (int i = 0; i < s.length(); i++) {
    // char c = s.charAt(i);
    // if (c > 'b') {
    // result += Math.min(aCount, bCount) * lesser;
    // aCount = 0;
    // bCount = 0;
    // } else if (c == 'a') {
    // if (x < y && bCount > 0) {
    // bCount--;
    // result += y;
    // } else {
    // aCount++;
    // }
    // } else {
    // if (x > y && aCount > 0) {
    // aCount--;
    // result += x;
    // } else {
    // bCount++;
    // };
    // }
    // }

    // result += Math.min(aCount, bCount) * lesser;

    // return result;
}