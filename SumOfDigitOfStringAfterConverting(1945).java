class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char x : s.toCharArray()) {
            sb.append(x - 'a' + 1);
        }
        while (k-- > 0) {
            int curr = 0;
            for (char x : sb.toString().toCharArray()) {
                curr += x - '0';
            }
            sb = new StringBuilder(String.valueOf(curr));
        }
        return Integer.parseInt(sb.toString());
    }
}