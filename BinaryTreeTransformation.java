class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeTransformation {

    public void transformBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        transform(root, false);
    }

    private void transform(TreeNode node, boolean shouldAdd) {
        if (node == null) {
            return;
        }
        transform(node.left, shouldAdd);
        transform(node.right, !shouldAdd);
        if (!shouldAdd) {
            node.val = (node.val % 2 == 0) ? node.val + 1 : node.val - 1;
        } else {
            node.val = (node.val % 2 == 0) ? node.val + 1 : node.val - 1;
        }
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);

        printTree(node.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeTransformation transformer = new BinaryTreeTransformation();
        System.out.println("Original Tree:");
        transformer.printTree(root);
        System.out.println();
        int rootVal = root.val;
        transformer.transformBinaryTree(root);
        root.val = rootVal;
        System.out.println("\nTransformed Tree:");
        transformer.printTree(root);
    }
}
