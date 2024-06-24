import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && i > q.peek() + k - 1)
                q.poll();

            if ((nums[i] + q.size()) % 2 == 0) {
                if (i + k > nums.length)
                    return -1;
                ans++;
                q.add(i);

            }
        }
        return ans;
    }
}