class Solution {
    public int countPrefixSuffixPairs(String[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (isPreSuf(arr[i], arr[j])) {
                    count++;
                }

            }
        }
        return count;
    }

    public static boolean isPreSuf(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        if (s2.substring(0, s1.length()).equals(s1)
                && s2.substring(s2.length() - s1.length(), s2.length()).equals(s1)) {
            return true;
        }
        return false;
    }
}