class Solution {
    public int minAddToMakeValid(String s) {
        int openCnt = 0, ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                openCnt++;
            else {
                if (openCnt == 0)
                    ans += 1;
                else {
                    openCnt = Math.max(openCnt - 1, 0);
                }
            }
        }
        return openCnt + ans;
    }
}