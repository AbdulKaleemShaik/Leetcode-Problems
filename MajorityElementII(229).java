class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = nums.length / 3;
        for (HashMap.Entry<Integer, Integer> m : map.entrySet()) {
            int i = m.getValue();
            if (i > size) {
                li.add(m.getKey());
            }
        }
        return li;
    }
}