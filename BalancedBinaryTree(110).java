import javax.swing.tree.TreeNode;

class Solution {
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left), rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) != -1;
    }
}