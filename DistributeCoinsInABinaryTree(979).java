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
    int res = 0;

    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int size = 1 + left[0] + right[0];
        int coins = root.val + left[1] + right[1];
        res += Math.abs(size - coins);
        return new int[] { size, coins };
    }
}