import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void solve(int[] nums, int target, int index, List<Integer> list, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (index == nums.length || target < nums[index]) {
            return;
        }

        int temp = nums[index];
        list.add(nums[index]);
        solve(nums, target - nums[index], index + 1, list, result);
        list.remove(list.size() - 1);

        int i = 1;
        while (index + i < nums.length && nums[index + i] == temp) {
            i++;
        }
        solve(nums, target, index + i, list, result);
        return;
    }
}