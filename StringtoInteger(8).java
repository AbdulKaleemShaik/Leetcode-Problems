class Solution {
    public int myAtoi(String s) {
        int n = 0, p = 0;
        double x = 0;
        s = s.trim();
        if (s.length() == 0)
            return 0;
        if (s.charAt(0) == '-')
            n = 1;
        else if (s.charAt(0) == '+')
            p = 1;
        for (int i = 0; i < s.length(); i++) {
            if ((n == 1 || p == 1) && i == 0)
                continue;
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                break;
            else
                x = x * 10 + s.charAt(i) - '0';
        }
        if (n == 1)
            x = (-1) * x;
        return (int) x;
    }
}
