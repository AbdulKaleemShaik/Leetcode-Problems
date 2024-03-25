import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        per(ans, new ArrayList<>(), nums, new boolean[nums.length]);
        List<List<Integer>> anss = new ArrayList<>();
        anss.addAll(ans);
        return anss;
    }

    public static void per(Set<List<Integer>> ans, List<Integer> li, int[] nums, boolean[] vis) {
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