import java.util.List;

class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = i;
            int c = 0;
            while (num > 0) {
                if ((num & 1) == 1)
                    c++;

                num = num >> 1;
            }

            if (c == k)
                sum += nums.get(i);
        }
        return sum;
    }
}