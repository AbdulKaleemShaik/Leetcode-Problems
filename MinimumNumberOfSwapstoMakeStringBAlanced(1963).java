class Solution {
    public int minSwaps(String s) {
        int openBracket = 0, imbalance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[')
                openBracket++;
            else if (openBracket == 0)
                imbalance++;
            else
                openBracket--;
        }
        return (imbalance + 1) / 2;
    }
}