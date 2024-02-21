class Solution {
    public String reverseVowels(String s) {
        char a[] = s.toCharArray();
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            if (!isVowel(a[start])) {
                start++;
            } else if (!isVowel(a[end])) {
                end--;
            } else {
                char temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
        }
        return String.valueOf(a);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {
            return true;
        }
        return false;
    }
}