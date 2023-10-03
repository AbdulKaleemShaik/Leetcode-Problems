class Solution {
    public int titleToNumber(String sr) {
        int sum = 0;
        for (int i = 0; i < sr.length(); i++) {
            sum = sum * 26;
            sum = sum + sr.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}