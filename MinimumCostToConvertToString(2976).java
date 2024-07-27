class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
         long ans = 0;
        // int maxi = 0;
        // for (char ch : original) {
        //     if (ch - 'a' > maxi)
        //         maxi = ch - 'a';
        // }
        long[][] gp = new long[26][26];
        for (int i = 0; i < gp.length; i++) {
            for (int j = 0; j < gp.length; j++) {
                if (i == j)
                    gp[i][j] = 0;
                else {
                    gp[i][j] = (int) 1e9 + 7;
                }
            }
        }
        for (int i = 0; i < original.length; i++) {
            gp[original[i] - 'a'][changed[i] - 'a'] = Math.min(cost[i], gp[original[i] - 'a'][changed[i] - 'a']);
        }
        // for (long[] ls : gp) {
        //     System.out.println(Arrays.toString(ls));
        // }
        for (int i = 0; i < gp.length; i++) {
            for (int j = 0; j < gp.length; j++) {
                for (int k = 0; k < gp.length; k++) {
                    gp[j][k] = Math.min(gp[j][k], gp[j][i] + gp[i][k]);
                }
            }
        }
        // for (long[] ls : gp) {
        //     System.out.println(Arrays.toString(ls));
        // }

        for (int i = 0; i < source.length(); i++) {
            if (gp[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == (int) 1e9 + 7) {
                return -1;

            }

            ans += gp[source.charAt(i) - 'a'][target.charAt(i) - 'a'];

        }
        return ans;
    }
}