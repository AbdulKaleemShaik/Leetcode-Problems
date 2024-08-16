class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
       int ans = 0;
        if (arrays.size() == 0)
            return 0;
        int curr_min = arrays.get(0).get(0), curr_max = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); i++) {
            ans = Math.max(ans,
                    Math.max(arrays.get(i).get(arrays.get(i).size() - 1) - curr_min, curr_max - arrays.get(i).get(0)));
            curr_min = Math.min(curr_min, arrays.get(i).get(0));
            curr_max = Math.max(curr_max, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        return ans;  
    }
}