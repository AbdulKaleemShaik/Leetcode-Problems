import java.util.LinkedList;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left,right;
    
}

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        TreeNode t = null;
        while (!q.isEmpty()) {
            int count = q.size();
            int prev = level % 2 == 0 ? -1 : Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                t = q.poll();

                if (level % 2 == 0) {
                    if (t.val % 2 == 0 || t.val <= prev) {
                        return false;
                    }
                } else {
                    if (t.val % 2 == 1 || t.val >= prev) {
                        return false;
                    }
                }
                prev = t.val;
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }

            }
            level++;
        }
        return true;
    }

}