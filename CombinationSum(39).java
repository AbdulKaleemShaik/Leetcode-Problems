import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        find(0, target, candidates, ans, new ArrayList<>());
        return ans;

    }

    public static void find(int idx, int target, int[] arr, List<List<Integer>> ans, List<Integer> li) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(li));
            }
            return;
        }
        if (arr[idx] <= target) {
            li.add(arr[idx]);
            find(idx, target - arr[idx], arr, ans, li);
            li.remove(li.size() - 1);
        }
        find(idx + 1, target, arr, ans, li);
    }
}