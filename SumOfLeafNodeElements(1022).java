class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return parent(root, 0);
    }

    public int parent(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = 2 * sum + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return parent(root.left, sum) + parent(root.right, sum);
    }
}