import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        Arrays.sort(arr);
        int start=0,end=0;
        for (int j = 0; j < arr.length; j++) {
            start=0;
            if(j>0 && arr[j]==arr[j-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n = outer.size();
            for (int i = start; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[j]);
                outer.add(internal);

            }

        }
        return outer;
    }
}