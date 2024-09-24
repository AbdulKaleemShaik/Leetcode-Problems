import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            int n = i;
            while (n != 0 && !set.contains(n)) {
                set.add(n);
                n = n / 10;
            }
        }
        for (int i : arr2) {
            int n = i;
            while (n != 0 && !set.contains(n)) {
                n = n / 10;
            }
            ans = Math.max(ans, (int) Math.log10(n) + 1);
        }
       // System.out.println(set);
        return ans;
    }
}