import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int ans = nums.length;
        long sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % p == 0)
            return 0;
        int rem = (int) (sum % p);
        int curr_sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            curr_sum = (curr_sum + nums[i]) % p;
            int prefix = (curr_sum - rem + p) % p;
            if (map.containsKey(prefix)) {
                ans = Math.min(ans, i - map.get(prefix));
            }
            map.put(curr_sum, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}