class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subroot) {
        if (root == null) {
            return false;
        }
        if (subroot == null) {
            return true;
        }

        return issame(root, subroot) || isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    public boolean issame(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) {
            return true;
        }
        if (root == null || subroot == null || root.val != subroot.val) {
            return false;
        }
        return issame(root.left, subroot.left) && issame(root.right, subroot.right);
    }
}