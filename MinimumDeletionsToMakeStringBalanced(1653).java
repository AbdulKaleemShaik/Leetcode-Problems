class Solution {
    public int minimumDeletions(String s) {
         int ans = s.length();
        int a_count = 0;
        for (int i = 0; i < s.length(); i++) {
            a_count += s.charAt(i) == 'a' ? 1 : 0;
        }
        int b_count = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = Math.min(ans, a_count + b_count);
            if (s.charAt(i) == 'a')
                a_count--;
            else
                b_count++;
        }
                ans=Math.min(ans, a_count+b_count);

        return ans;
    }
}