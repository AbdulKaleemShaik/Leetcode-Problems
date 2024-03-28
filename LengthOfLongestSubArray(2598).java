import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int j2 = 0; j2 < nums.length; j2++) {
            map.put(nums[j2], map.getOrDefault(nums[j2], 0) + 1);
            while (map.get(nums[j2]) > k) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                i++;
            }
            count = Math.max(count, j2 - i + 1);
        }
        return count;
    }
}