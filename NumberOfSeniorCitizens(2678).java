class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (int i = 0; i < details.length; i++) {
            int num = Integer.parseInt(details[i].substring(11, 13));
            ans += num > 60 ? 1 : 0;
        }
        return ans;
    }
}