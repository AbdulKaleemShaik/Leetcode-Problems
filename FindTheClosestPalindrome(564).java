import java.util.HashSet;
import java.util.Set;

class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        Set<String> uniquePalindromeNumbers = new HashSet<>();

        if (n.equals("1"))
            return "0";

        String prefix = n.substring(0, (len + 1) / 2);
        long prefixNumber = Long.parseLong(prefix);

        for (long i : new long[] { -1, 0, 1 }) {
            String newPrefix = Long.toString(prefixNumber + i);
            String candidate;
            if (len % 2 == 0) {
                candidate = newPrefix + new StringBuilder(newPrefix).reverse().toString();
            } else {
                candidate = newPrefix
                        + new StringBuilder(newPrefix.substring(0, newPrefix.length() - 1)).reverse().toString();
            }
            uniquePalindromeNumbers.add(candidate);
        }

        uniquePalindromeNumbers.add(Long.toString((long) Math.pow(10, len - 1) - 1));
        uniquePalindromeNumbers.add(Long.toString((long) Math.pow(10, len) + 1));

        uniquePalindromeNumbers.remove(n);

        String closestPalindrome = "";
        long minDiff = Long.MAX_VALUE;
        long num = Long.parseLong(n);
        for (String candidate : uniquePalindromeNumbers) {
            long candidateNum = Long.parseLong(candidate);
            long difference = Math.abs(candidateNum - num);
            if (difference < minDiff
                    || (difference == minDiff && candidateNum < Long.parseLong(closestPalindrome))) {
                minDiff = difference;
                closestPalindrome = candidate;
            }
        }

        return closestPalindrome;
    }
}