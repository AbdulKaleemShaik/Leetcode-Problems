import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            if (map.containsKey(j) && i - map.get(j) <= k) {
                return true;
            }
            map.put(j, i);
        }
        return false;
    }
}