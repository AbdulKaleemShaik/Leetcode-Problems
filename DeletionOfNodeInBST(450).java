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

class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.val == val) {
                if (root.left == null && root.right == null) {
                    return null;
                }
                if (root.left == null) {
                    return root.right;
                }
                if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode succ = inorder(root);
                    root.val = succ.val;
                    root.right = deleteNode(root.right, succ.val);
                }
            }
        }
        return root;
    }

    public static TreeNode inorder(TreeNode root) {
        TreeNode lef = root.right;
        while (lef.left != null) {
            lef = lef.left;
        }
        return lef;
    }
}