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
class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode() {
    };

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder st = new StringBuilder();
        String lefString = findTraversal(root, st, startValue).toString();
        st = new StringBuilder();
        String righString = findTraversal(root, st, destValue).toString();
        int i = 0;
        while (i < Math.min(lefString.length(), righString.length())) {
            if (lefString.charAt(i) != righString.charAt(i))
                break;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < lefString.length() - i; j++) {
            sb.append("U");
        }
        sb.append(righString.substring(i, righString.length()));

        return sb.toString();
    }

    public StringBuilder findTraversal(TreeNode root, StringBuilder s, int startValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue) {
            return s;
        }
        s.append("L");
        StringBuilder s1 = findTraversal(root.left, s, startValue);
        if (s1 != null)
            return s1;
        s.deleteCharAt(s.length() - 1);
        s.append("R");
        StringBuilder s2 = findTraversal(root.right, s, startValue);
        if (s2 != null)
            return s2;
        s.deleteCharAt(s.length() - 1);
        return null;
    }
}