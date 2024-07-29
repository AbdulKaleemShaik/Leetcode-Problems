class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 1; i < rating.length; i++) {
            int left_smaller_count = 0, right_greater_count = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    left_smaller_count++;
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i])
                    right_greater_count++;
            }
            ans += (left_smaller_count * right_greater_count);
            ans += ((i - left_smaller_count) * (rating.length - i - right_greater_count - 1));
        }
        return ans;
    }
}