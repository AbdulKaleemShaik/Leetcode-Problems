class Solution {
    public int differenceOfSum(int[] nums) {
        int i = 0;
        int sum = 0, dsum = 0;
        while (i != nums.length) {
            int num = nums[i];
            sum = sum + num;
            while (num > 0) {
                int rem = num % 10;
                dsum = dsum + rem;
                num = num / 10;
            }
            i++;
        }
        return sum - dsum;
    }
}