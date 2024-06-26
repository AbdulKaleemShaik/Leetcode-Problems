import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> nodess = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        TreeNode curr = constructBST(root, 0, nodess.size() - 1);
        return curr;
    }

    public TreeNode constructBST(TreeNode root, int low, int high) {
        if (low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode curr = new TreeNode(nodess.get(mid));
        curr.left = constructBST(root, low, mid - 1);
        curr.right = constructBST(root, mid + 1, high);
        return curr;
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        nodess.add(root.val);
        inOrder(root.right);
    }
}

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
