import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
       Arrays.sort(position);
       int start = 1;
       int ans = 1;
       int end = position[position.length - 1] - position[0];
       while (start <= end) {
           int mid = (start + end) / 2;
           if (isPossible(position, mid, m)) {
               ans = mid;
               start = mid + 1;
           } else {
               end = mid - 1;
           }
       }
       return ans;

   }

   private boolean isPossible(int[] arr, int mid, int m) {
       int prev = arr[0];
       m -= 1;
       for (int i = 1; i < arr.length; i++) {
           if (arr[i] - prev >= mid) {
               m -= 1;
               prev = arr[i];
           }
           if (m == 0)
               return true;
       }
       return false;
   }
}