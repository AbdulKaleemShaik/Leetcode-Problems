class Solution {
    Set<Integer> todelete;
    List<TreeNode> res;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        todelete = new HashSet<>();
        res = new ArrayList<>();
        for (int i : to_delete)
            todelete.add(i);
        helper(root, true);
        return res;
    }

    private TreeNode helper(TreeNode node, boolean is_root) {
        if (node == null)
            return null;
        boolean deleted = todelete.contains(node.val);
        if (is_root && !deleted)
            res.add(node);
        node.left = helper(node.left, deleted);
        node.right = helper(node.right, deleted);
        return deleted ? null : node;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (Integer integer : to_delete) {
            toDelete.add(integer);
        }
        System.out.println(toDelete);
        Set<TreeNode> nodes = new HashSet<>();
        nodes.add(root);
        dfs(root, toDelete, nodes);
        List<TreeNode> ans = new ArrayList<>(nodes);
        return ans;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> toDelete, Set<TreeNode> nodes) {
        if (root == null)
            return null;
        TreeNode returningVal = root;
        if (toDelete.contains(root.val)) {
            returningVal = null;
            if (root.left != null) {
                nodes.add(root.left);
            }
            if (root.right != null) {
                nodes.add(root.right);
            }
            nodes.remove(root);
        }

        root.left = dfs(root.left, toDelete, nodes);
        root.right = dfs(root.right, toDelete, nodes);
        return returningVal;
    }
}import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

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