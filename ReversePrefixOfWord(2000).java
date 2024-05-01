class Solution {
    public String reversePrefix(String word, char ch) {
        int j = Integer.MAX_VALUE;
        char[] c = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (c[i] == ch) {
                j = i;
                break;
            }
        }
        if (j == Integer.MAX_VALUE) {
            return word;
        }
        int size = j / 2;
        for (int i = 0; i <= size; i++) {
            char cuuurr = c[i];
            c[i] = c[j];
            c[j] = cuuurr;
            j--;
        }
        return new String(c);

    }
}