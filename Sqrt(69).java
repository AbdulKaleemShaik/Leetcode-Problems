class Solution {
    public int mySqrt(int n) {
       int f = 0;
        int e = n;
        
        while (f <= e) {
            int mid = f + (e - f) / 2;
            if (mid * mid == n) {
                return mid;
            }
            if (mid * mid > n) {
                e = mid - 1;
            } else {
                f = mid + 1;
            }
        }
        return e;
    }
    
}