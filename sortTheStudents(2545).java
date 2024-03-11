class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int idx = 0;
        for (int i = 0; i < score.length - 1; i++) {
            idx = i;
            for (int j = i + 1; j < score.length; j++) {
                if (score[idx][k] < score[j][k]) {
                    idx = j;
                }
            }
            int[] temp = score[i];
            score[i] = score[idx];
            score[idx] = temp;
        }
        return score;
    }
}