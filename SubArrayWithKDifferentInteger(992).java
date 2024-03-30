class Solution {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static int helper(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, cnt = 0;
        while (right < arr.length) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            while (map.size() > k) {
                map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            cnt += (right - left + 1);
            right++;
        }
        return cnt;

    }

}