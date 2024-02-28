import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode t = null;
        while (!q.isEmpty()) {
            t = q.poll();
            if (t.right != null) {
                q.add(t.right);
            }
            if (t.left != null) {
                q.add(t.left);
            }
        }
        return t.val;
    }
}