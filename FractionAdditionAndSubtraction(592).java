class Solution {
    public String fractionAddition(String expression) {
        String[] arr = expression.split("/|(?=[-+])");
        if (arr.length == 0)
            return null;
        if (arr.length == 2)
            return arr[0] + "/" + arr[1];
        int numerator =Integer.valueOf(arr[0]);
        int denominator = Integer.valueOf(arr[1]);
        for (int i = 2; i < arr.length; i += 2) {
            int currNumerator = Integer.parseInt(arr[i]);
            int currDenominator = Integer.parseInt(arr[i + 1]);
            int lcm = LCM(denominator, currDenominator);
            if (numerator == 0) {
                lcm = currDenominator;
            }
            if (numerator == 0) {
                numerator = currNumerator * (lcm / currDenominator);
            } else {
                numerator = numerator * (lcm / denominator) + currNumerator * (lcm / currDenominator);
            }
            denominator = lcm;

        }
        if (numerator == 0) {
            denominator = 1;
        }
        int gcd=gcd(numerator, denominator);
        if (gcd<0) {
            gcd=-gcd;
            
        }
        numerator/=gcd;
        denominator/=gcd;
        return numerator + "/" + denominator;
    }

    public int LCM(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}