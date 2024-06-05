class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new LinkedList();
        int[] freqOfFirstWord = getFreq(words[0]);
        int[] freqOfUpcomingWords = new int[26];
        for (int i = 1; i < words.length; i++) {
            freqOfUpcomingWords = getFreq(words[i]);
            for (int j = 0; j < 26; j++) {
                freqOfFirstWord[j] = Math.min(freqOfFirstWord[j], freqOfUpcomingWords[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freqOfFirstWord[i] != 0) {
                while (freqOfFirstWord[i] > 0) {
                    ans.add(String.valueOf((char) (i + 'a')));
                    freqOfFirstWord[i]--;
                }
            }
        }
        return ans;

    }

    public int[] getFreq(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        return cnt;
    }
}