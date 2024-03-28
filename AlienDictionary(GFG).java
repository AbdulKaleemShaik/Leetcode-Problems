import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String findOrder(String[] dict, int N, int K) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> gp = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            gp.add(new ArrayList<>());
        }
        for (int i = 0; i < dict.length - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                    gp.get(dict[i].charAt(j) - 'a').add(dict[i + 1].charAt(j) - 'a');
                    break;
                }
            }
        }
        int[] inorder = new int[K];
        for (int i = 0; i < inorder.length; i++) {
            for (int j = 0; j < gp.get(i).size(); j++) {
                inorder[gp.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);
            for (int i : gp.get(curr)) {
                inorder[i]--;
                if (inorder[i] == 0) {
                    q.add(i);
                }
            }
        }
        String anss = "";
        for (Integer it : ans) {
            anss = anss + (char) (it + (int) 'a');
        }
        return anss;

    }
}