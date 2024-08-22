class Solution {
    public int findComplement(int num) {
         int ans = 0;
        int power = 0;
        while (num != 0) {
            int rem = (num & 1);
             //int pow=(int) Math.pow(2, power++);
            ans += rem == 1 ? 0 : (int) Math.pow(2, power);
            power++;
            num >>= 1;
        }
        return ans;
    }
}