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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        dfs(root, root, target, "root");
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public void dfs(TreeNode currNode, TreeNode parNode, int target, String dir) {

        if (currNode.left != null) {
            dfs(currNode.left, currNode, target, "left");
        }
        if (currNode.right != null) {
            dfs(currNode.right, currNode, target, "right");
        }
        check(currNode, parNode, target, dir);
    }

    public void check(TreeNode currNode, TreeNode parNode, int target, String dir) {
        if (currNode.left == null && currNode.right == null) {
            if (currNode.val == target) {
                if (dir.equals("left"))
                    parNode.left = null;
                else
                    parNode.right = null;
            }
            return;
        }
    }
}