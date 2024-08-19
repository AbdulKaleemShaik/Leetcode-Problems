class Solution {
    public int minSteps(int n) {
         if (n == 1)
             return 0;
         return 1 + findMinSteps(1, 1, n);
     }
 
     private int findMinSteps(int count, int paste, int n) {
         if (count == n)
             return 0;
         if (count > n)
             return Integer.MAX_VALUE / 2;
 
         int copyAndPaste = 2 + findMinSteps(count * 2, count, n);
         int pasteOnly = 1 + findMinSteps(count + paste, paste, n);
 
         return Math.min(copyAndPaste, pasteOnly);
     }
 }