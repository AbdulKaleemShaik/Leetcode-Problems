class Solution {
    public static int beautySum(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] charfreq = new int[26];
            for (int j = i; j < s.length(); j++) {
                charfreq[s.charAt(j) - 'a']++;
                total += freq(charfreq);
            }
        }
        return total;
    }

    public static int freq(int[] charfreq) {
        int minfreq = Integer.MAX_VALUE;
        int maxfreq = 0;
        for (int i : charfreq) {
            if (i > maxfreq) {
                maxfreq = i;
            }
            if (i > 0 && i < minfreq) {
                minfreq = i;
            }
        }
        return maxfreq - minfreq;
    }
}