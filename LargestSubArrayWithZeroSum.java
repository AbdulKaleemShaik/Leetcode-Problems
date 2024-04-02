
import java.util.HashMap;

 class Solution {
    public static int getLongestZeroSumSubarrayLength(int[] arr) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}