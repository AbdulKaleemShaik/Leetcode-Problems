
class Solution {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int count = 0;
        String ans = " ";
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
            if (count == k) {
                ans = s.substring(0, i);
                break;
            }
            if (count < k) {
                ans = s;
            }
        }
        return ans;
    }
}