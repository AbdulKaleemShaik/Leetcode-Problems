class Solution {
    public int[] evenOddBit(int n) {
        int n1 = 0;
        int n2 = 0;
        if(n == 0) return new int[]{0, 0};
        int idx = 0;
        
        while(n > 0) {
            if(idx % 2 == 0) {
                if((n & 1) == 1) n1++;
            }
            else {
                if((n & 1) == 1) n2++;
            }
            idx++;
            n = (n >> 1);
        }
        
        return new int[]{n1, n2};
    }
}