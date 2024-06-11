class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int i : arr1) {
            cnt[i]++;
        }
        int[] ans = new int[arr1.length];
        int j = 0;
        for (int i : arr2) {
            if (cnt[i] > 0) {
                int freq = cnt[i];
                while (freq-- > 0) {
                    ans[j++] = i;
                    cnt[i]--;
                }
            }
        }
        for (int i = 0; i < 1001; i++) {
            if (cnt[i] > 0) {
                int freq = cnt[i];
                while (freq-- > 0) {
                    ans[j++] = i;
                    cnt[i]--;
                }
            }
        }
        return ans;
    }
}