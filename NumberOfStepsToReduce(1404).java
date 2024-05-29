class Solution {
    public int numSteps(String s) {
         int carry = 0, cnt = 0;
        for (int i = s.length() - 1; i >= 1; i--) {
            int s1 = s.charAt(i) - '0';
            if (s1 + carry == 1) {
                carry = 1;
                cnt += 2;
            } else {
                cnt++;
            }

        }
        return cnt + carry;
    }
}