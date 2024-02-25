import java.util.HashSet;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        if (nums.length % 2 != 0) {
            return false;
        }
        HashSet<Integer> num1 = new HashSet<>();
        HashSet<Integer> num2 = new HashSet<>();
        for (int n : nums) {
            if (!num1.contains(n)) {
                num1.add(n);
            } else if (!num2.contains(n)) {
                num2.add(n);
            } else {
                return false;
            }
        }

        return true;

    }
}