class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] a = new int[300];
        int[] b = new int[300];

        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i)] != b[t.charAt(i)])
                return false;

            a[s.charAt(i)] = i + 1;
            b[t.charAt(i)] = i + 1;
        }

        return true;
    }
}