import java.util.*;

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> outer = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        outer.add(arr);
        for (int i = 1; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = outer.get(i - 1);
            for (int j = 1; j < prev.size(); j++) {
                temp.add(prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            outer.add(temp);
        }

        return outer;
    }
}