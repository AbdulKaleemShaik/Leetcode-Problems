import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        int e = nums.length;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int ans = cnt(nums, mid);

            if (ans == mid) {
                return mid;
            } else if (ans > mid) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    private int cnt(int[] nums, int mid) {
        int count = 0;
        for (int i : nums) {
            if (i >= mid) {
                count++;
            }
        }
        return count;
    }
}