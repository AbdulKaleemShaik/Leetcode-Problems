class Solution {
    public long maxPoints(int[][] points) {
       int m = points.length, n = points[0].length;
       long[] curr_arr = new long[n];
       for (int j = 0; j < n; j++) {
           curr_arr[j] = points[0][j];
       }

       for (int i = 1; i < m; i++) {
           long[] left_max_arr = new long[n];
           long[] right_max_arr = new long[n];

           left_max_arr[0] = curr_arr[0];
           for (int j = 1; j < n; j++) {
               left_max_arr[j] = Math.max(left_max_arr[j - 1] - 1, curr_arr[j]);
           }

           right_max_arr[n - 1] = curr_arr[n - 1];
           for (int j = n - 2; j >= 0; j--) {
               right_max_arr[j] = Math.max(right_max_arr[j + 1] - 1, curr_arr[j]);
           }

           for (int j = 0; j < n; j++) {
               curr_arr[j] = points[i][j] + Math.max(left_max_arr[j], right_max_arr[j]);
           }
       }

       long maxPoints = 0;
       for (long pointsValue : curr_arr) {
           maxPoints = Math.max(maxPoints, pointsValue);
       }

       return maxPoints;
   }
}