import java.util.HashMap;

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
    static int preorderidx = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1, map);

    }

    public static TreeNode helper(int[] preorder, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right) {
            return null;
        }
        int current = preorder[preorderidx];
        int inorderidx = map.get(current);
        TreeNode root = new TreeNode(current);
        preorderidx++;
        root.left = helper(preorder, left, inorderidx - 1, map);
        root.right = helper(preorder, inorderidx + 1, right, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode t = buildTree(preorder, inorder);
    }
}