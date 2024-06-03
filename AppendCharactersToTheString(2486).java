class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        while (j < s.length() && i < t.length()) {
            if (s.charAt(j) == t.charAt(i))
                i++;
            j++;
        }
        return t.length() - i;
    }
}