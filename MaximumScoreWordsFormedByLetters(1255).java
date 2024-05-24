public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a']++;
        }
        return findList(0, words, score, cnt);
    }

    private int findList(int i, String[] words, int[] score, int[] cnt) {
        if (i >= words.length)
            return 0;
        int currScore = 0;
        boolean isPossible = true;
        int[] dataArr = cnt.clone();
        for (char c : words[i].toCharArray()) {
            if (dataArr[c - 'a'] > 0) {
                currScore += score[c - 'a'];
                dataArr[c - 'a']--;
            } else {
                isPossible = false;
                break;
            }
        }
        int ans = 0;
        if (isPossible) {
            ans = currScore + findList(i + 1, words, score, dataArr);
        }
        ans = Math.max(ans, findList(i + 1, words, score, cnt));
        return ans;
    }
} MaximumScoreWordsFormedByLetters(1255) {
    
}
