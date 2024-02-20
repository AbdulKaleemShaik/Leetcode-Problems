class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int max = 0;

        for(int x : nums)
            for(int y : nums)
                if(Math.abs(x - y) <= Math.min(x, y))
                    max = Math.max(max, x ^ y);

        return max;
    }
}