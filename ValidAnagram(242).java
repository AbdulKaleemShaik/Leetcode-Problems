import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sr = s.toCharArray();
        Arrays.sort(sr);
        s = new String(sr);
        char[] srt = t.toCharArray();
        Arrays.sort(srt);
        t = new String(srt);
        return s.equals(t);
    }
}