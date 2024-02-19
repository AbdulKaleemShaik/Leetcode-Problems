class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder("");
        int length = s.length();
        int length_sb;
        for (int i = 0; i < length; i++) {
            length_sb = sb.length();
            if (length_sb != 0 && sb.charAt(length_sb - 1) == s.charAt(i)) {
                sb.deleteCharAt(length_sb - 1);
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}