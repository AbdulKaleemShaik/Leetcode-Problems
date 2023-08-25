import java.util.*;

class Solution {
    public List<Integer> getRow(int n) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        outer.add(arr);
        for (int i = 1; i < n+1; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> prev = outer.get(i - 1);
            
            for (int j = 1; j < prev.size(); j++) {
                temp.add(prev.get(j - 1) + prev.get(j));

            }
            temp.add(1);
            outer.add(temp);

        }

        return outer.get(n );
    }
}