class Solution {
    public int longestSubarray(int[] nums, int limit) {
         int ans = 1;
        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();
        int start = 0;
        for (int end = 0; end < nums.length; end++) {

            while (!min.isEmpty() && min.getLast() > nums[end])
                min.removeLast();
            while (!max.isEmpty() && max.getLast() < nums[end])
                max.removeLast();
            min.addLast(nums[end]);
            max.addLast(nums[end]);
            while (max.getFirst() - min.getFirst() > limit) {
                if (min.getFirst() == nums[start])
                    min.removeFirst();
                if (max.getFirst() == nums[start])
                    max.removeFirst();
                start++;
            }
            ans=Math.max(ans,end-start+1);
         
        }
        return ans;
    }
}