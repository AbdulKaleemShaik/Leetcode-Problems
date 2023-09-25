class Solution {
    public int sumNumbers(TreeNode root) {
        int k = sum(root, 0);
        return k;
    }

    public int sum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sum(root.left, sum) + sum(root.right, sum);
    }
}