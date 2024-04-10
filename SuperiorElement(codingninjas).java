import java.util.*;
import java.util.ArrayList;

class Solution {
    public static List<Integer> superiorElements(int[] a) {
        List<Integer> li = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > max) {
                li.add(a[i]);
            }
            max = Math.max(max, a[i]);
        }
        Collections.sort(li);
        return li;
    }
}