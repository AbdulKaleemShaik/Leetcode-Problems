class Solution {
    public int minOperations(String[] logs) {
        int ans = 0;
        for (int i = 0; i < logs.length; i++) {
            int len = logs[i].length();
            if (len >= 3) {
                if (logs[i].equals("../")) {
                    ans--;
                    ans = ans < 0 ? 0 : ans;
                } else {
                    ans++;
                }
            } else {
                if (logs[i].equals("./")) {
                    continue;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }
}
//   public int minOperations(String[] logs) {
//         int res = 0;
//         for (String log: logs) {
//             res += add(log,res);
//         }
//         return res;
//     }
//     private int add(String log, int res) {
//         return log.charAt(1) == '.' ? res == 0 ? 0 : -1 : log.charAt(0) == '.' ? 0 : 1;
//     }