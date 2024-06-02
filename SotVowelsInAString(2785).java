class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> li = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c))
                li.add(c);
        }
        Collections.sort(li);
        int j = 0;
        char[] ans = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(ans[i])) {
                ans[i] = li.get(j++);
            }
        }
        return new String(ans);

    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {
            return true;
        }
        return false;
    }

}