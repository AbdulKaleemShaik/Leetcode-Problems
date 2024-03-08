class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
         int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxi=Math.max(maxi,map.get(nums[i]));
        }
       
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getValue();
            if (k > maxi) {
                maxi = k;
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getValue();
            if (k == maxi) {
                sum += k;
            }
        }
        return sum;
    }
}