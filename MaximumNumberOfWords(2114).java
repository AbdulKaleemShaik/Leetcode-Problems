class Solution {
     public static int mostWordsFound(String[] sen) {
          int maxlen = 0;
        for (String string : sen) {
            int curlen = string.split(" ").length;
            if (curlen > maxlen) {
                maxlen = curlen;
            }
        }
        return maxlen;
    }
}