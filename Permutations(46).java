import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        per(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }

    public static void per(List<List<Integer>> ans, List<Integer> li, int[] nums, boolean[] vis) {
        if (li.size() == nums.length) {
            ans.add(new ArrayList<>(li));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                li.add(nums[i]);
                per(ans, li, nums, vis);
                li.remove(li.size() - 1);
                vis[i] = false;
            }
        }
    }
}