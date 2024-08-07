class Solution {
     public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String result = converNumberToWords(num % 1000);
        num = num / 1000;
        if (num > 0 && num % 1000 > 0) {
            result = converNumberToWords(num % 1000) + "Thousand " + result;
        }
        num = num / 1000;
        if (num > 0 && num % 1000 > 0) {
            result = converNumberToWords(num % 1000) + "Million " + result;
        }
        num = num / 1000;
        if (num > 0) {
            result = converNumberToWords(num % 1000) + "Billion " + result;
        }
        return result.trim();
    }

    public String converNumberToWords(int num) {
        String[] digit = new String[] { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine" };
        String[] teen = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                "Seventeen", "Eighteen", "Nineteen" };
        String[] ten = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
                "Ninety" };
        String ans = "";
        if (num > 99) {
            ans += digit[num / 100] + " Hundred ";
        }
        num = num % 100;
        if (num < 20 && num > 9) {
            ans += teen[num % 10] + " ";
        } else {
            if (num > 19) {
                ans += ten[num / 10] + " ";
            }
            num = num % 10;
            if (num > 0)
                ans += digit[num] + " ";
        }
        return ans;
    }
}