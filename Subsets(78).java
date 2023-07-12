import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] arr) {
       List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int list : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(list);
                outer.add(internal);

            }

        }
        return outer;
    }
}