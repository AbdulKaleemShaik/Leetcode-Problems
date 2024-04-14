class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            String last = ans;
            int l = ans.length();
            int j = 0;
            ans = "";
            while (j < l) {
                int k = j;
                while (k < l && last.charAt(k) == last.charAt(j)) {
                    k++;
                }
                ans += "" + (k - j) + last.charAt(j);
                j = k;

            }
        }
        return ans;
    }
}