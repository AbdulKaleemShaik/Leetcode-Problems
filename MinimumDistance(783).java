/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        int[] ans = { Integer.MAX_VALUE };
        TreeNode[] prev = { null };
        dfs(root, prev, ans);
        return ans[0];
    }

    private void dfs(TreeNode root, TreeNode[] prev, int[] ans) {
        if (root == null)
            return;
        dfs(root.left, prev, ans);
        if (prev[0] != null)
            ans[0] = Math.min(ans[0], Math.abs(prev[0].val - root.val));
        prev[0] = root;
        dfs(root.right, prev, ans);
    }
}