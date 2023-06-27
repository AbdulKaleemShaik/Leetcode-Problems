class Solution {
    public int romanToInt(String s) {
        String symbol = "MDCLXVI";
        int[] value = { 1000, 500, 100, 50, 10, 5, 1 };

        int prev = 0;
        int num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = value[symbol.indexOf(s.charAt(i))];
            if (prev <= current)
                num += current;
            else
                num -= current;
            prev = current;

        }

        return num;
    }
}