import java.util.ArrayList;

import javax.swing.tree.TreeNode;

class Solution {
    public ArrayList<Integer> l = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode temp = new TreeNode();
        TreeNode ans = temp;
        for (int i = 0; i < l.size(); i++) {
            TreeNode r = new TreeNode(l.get(i));
            temp.left = null;
            temp.right = r;
            temp = temp.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        l.add(node.val);
        inorder(node.right);
    }
}